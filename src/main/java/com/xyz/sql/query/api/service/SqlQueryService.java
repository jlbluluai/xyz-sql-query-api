package com.xyz.sql.query.api.service;

import com.xyz.sql.query.api.common.exception.BusinessException;
import com.xyz.sql.query.api.common.param.PageBack;
import com.xyz.sql.query.api.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xyz
 * @date 2023/3/10
 */
@Service
@Slf4j
public class SqlQueryService {

    private static final String URL_TEMPLATE = "jdbc:mysql://%s:%s/%s";


    private static final String COUNT_SQL_TEMPLATE = "select count(*) from %s";
    private static final String DATALIST_SQL_TEMPLATE = "select %s from %s";

    public static void main(String[] args) {

        String sql = "INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user%s', '用户%s', %s, %s);";
        for (int i = 1; i <= 100; i++) {
            int s = new Random().nextInt(2);
            int r = new Random().nextInt(2);

            System.out.printf((sql) + "%n", i, i, s, r);
        }


    }

    /**
     * 连接数据库并获取表信息
     */
    public DatabaseConnectResult connectDatabase(DatabaseConnectParam param, HttpSession session) throws BusinessException {
        // 组合连接信息
        String url = String.format(URL_TEMPLATE, param.getHost(), param.getPort(), param.getDatabase());

        // 连接数据库
        List<TableInfo> tableInfos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, param.getUser(), param.getPassword())) {
            // 取数据库表信息
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet rs = dbm.getTables(param.getDatabase(), "%", "%", new String[]{"TABLE"});
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                String tableRemark = rs.getString("REMARKS");

                TableInfo tableInfo = new TableInfo();
                tableInfo.setTableName(tableName);
                tableInfo.setTableDesc(tableRemark);
                tableInfos.add(tableInfo);
            }
        } catch (Exception e) {
            log.error("SqlQueryService#connectDatabase error param={}", param, e);
            throw new BusinessException("连接数据库发生异常： " + e.getMessage());
        }

        // 在session存储连接信息，本次会话后续的连接信息可直接从session获取
        session.setAttribute("connectInfo", param);

        return DatabaseConnectResult.builder()
                .tables(tableInfos)
                .build();
    }

    /**
     * 获取指定表信息
     */
    public List<ColumnInfo> queryTablesColumns(String tableName, HttpSession session) {
        // 取连接信息
        DatabaseConnectParam param = getConnectParamFromSession(session);
        if (param == null) {
            throw new BusinessException("数据库连接信息异常");
        }

        // 获取列数据
        String url = String.format(URL_TEMPLATE, param.getHost(), param.getPort(), param.getDatabase());
        List<ColumnInfo> columnInfos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, param.getUser(), param.getPassword())) {
            DatabaseMetaData dbm = conn.getMetaData();

            // 判断表是否存在
            ResultSet tableRs = dbm.getTables(param.getDatabase(), "%", tableName, new String[]{"TABLE"});
            if (!tableRs.next()) {
                throw new BusinessException("表不存在");
            }

            // 查询列信息
            ResultSet rs = dbm.getColumns(param.getDatabase(), "%", tableName, "%");
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");
                String columnRemark = rs.getString("REMARKS");

                ColumnInfo columnInfo = new ColumnInfo();
                columnInfo.setColumnName(columnName);
                columnInfo.setColumnDesc(columnRemark);
                columnInfos.add(columnInfo);
            }
            if (CollectionUtils.isEmpty(columnInfos)) {
                throw new BusinessException("列信息不存在");
            }
        } catch (Exception e) {
            log.error("SqlQueryService#queryTablesColumns error param={}", param, e);
            throw new BusinessException("连接数据库发生异常： " + e.getMessage());
        }

        // 在session存储当前表
        session.setAttribute("tableName", tableName);
        session.setAttribute("columnInfos", columnInfos);

        return columnInfos;
    }

    private DatabaseConnectParam getConnectParamFromSession(HttpSession session) {
        try {
            return (DatabaseConnectParam) session.getAttribute("connectInfo");
        } catch (Exception e) {
            log.error("SqlQueryService#getConnectParamFromSession error ", e);
            return null;
        }
    }

    /**
     * 分页查询表数据
     */
    public PageBack<Map<String, String>> queryTableDataList(DataListQueryParam param, HttpSession session) {
        // 取连接信息
        DatabaseConnectParam connectParam = getConnectParamFromSession(session);
        if (connectParam == null) {
            throw new BusinessException("数据库连接信息异常");
        }
        // 取当前表
        String tableName = (String) session.getAttribute("tableName");
        if (!StringUtils.hasText(tableName)) {
            throw new BusinessException("表信息异常");
        }
        // 取列信息
        List<ColumnInfo> columnInfos;
        try {
            columnInfos = (List<ColumnInfo>) session.getAttribute("columnInfos");
        } catch (Exception e) {
            log.error("SqlQueryService#queryTableDataList error ", e);
            throw new BusinessException("列信息异常");
        }
        if (CollectionUtils.isEmpty(columnInfos)) {
            throw new BusinessException("列信息异常");
        }

        // 执行查询
        String url = String.format(URL_TEMPLATE, connectParam.getHost(), connectParam.getPort(), connectParam.getDatabase());
        try (Connection conn = DriverManager.getConnection(url, connectParam.getUser(), connectParam.getPassword())) {
            int count = selectCount(param, tableName, conn);
            List<Map<String, String>> dataList = selectDataList(param, tableName, columnInfos, conn);

            PageBack<Map<String, String>> result = new PageBack<>();
            result.setTotal(count);
            result.setTotalPages(count % param.getPageSize() == 0 ? count / param.getPageSize() : count / param.getPageSize() + 1);
            result.setDataList(dataList);

            return result;
        } catch (Exception e) {
            log.error("SqlQueryService#queryTableDataList error param={}", param, e);
            throw new BusinessException("连接数据库发生异常： " + e.getMessage());
        }
    }

    /**
     * 查询表数据总量
     */
    public int selectCount(DataListQueryParam param, String tableName, Connection conn) {
        int count = 0;

        // 拼接SQL
        StringBuilder sql = new StringBuilder(String.format(COUNT_SQL_TEMPLATE, tableName));
        if (StringUtils.hasText(param.getWhereSql())) {
            sql.append(" where ").append(param.getWhereSql());
        }
        log.info("execute sql is: {}", sql);

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            log.error("SqlQueryService#selectCount error param={} tableName={}", param, tableName, e);
            throw new BusinessException("查询表数据总量发生异常： " + e.getMessage());
        }

        return count;
    }

    /**
     * 分页查询数据列表
     */
    public List<Map<String, String>> selectDataList(DataListQueryParam param, String tableName, List<ColumnInfo> columnInfos, Connection conn) {
        List<Map<String, String>> dataList = new ArrayList<>();

        // 拼接SQL
        String resultSql = columnInfos.stream().map(ColumnInfo::getColumnName).collect(Collectors.joining(","));
        StringBuilder sql = new StringBuilder(String.format(DATALIST_SQL_TEMPLATE, resultSql, tableName));
        if (StringUtils.hasText(param.getWhereSql())) {
            sql.append(" where ").append(param.getWhereSql());
        }
        if (StringUtils.hasText(param.getOrderList())) {
            sql.append(" order by ").append(param.getOrderList());
        }
        sql.append(" limit ?,?");
        log.info("execute sql is: {}", sql);

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setInt(1, (param.getPage() - 1) * param.getPageSize());
            pstmt.setInt(2, param.getPageSize());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Map<String, String> data = new HashMap<>();
                for (ColumnInfo columnInfo : columnInfos) {
                    String item = rs.getString(columnInfo.getColumnName());
                    if (item == null) {
                        item = "null";
                    }
                    data.put(columnInfo.getColumnName(), item);
                }
                dataList.add(data);
            }
        } catch (Exception e) {
            log.error("SqlQueryService#selectDataList error param={} tableName={}", param, tableName, e);
            throw new BusinessException("分页查询数据列表发生异常： " + e.getMessage());
        }

        return dataList;
    }

}
