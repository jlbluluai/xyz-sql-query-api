package com.xyz.sql.query.api.controller;

import com.xyz.sql.query.api.common.param.PageBack;
import com.xyz.sql.query.api.domain.ColumnInfo;
import com.xyz.sql.query.api.domain.DataListQueryParam;
import com.xyz.sql.query.api.domain.DatabaseConnectParam;
import com.xyz.sql.query.api.domain.DatabaseConnectResult;
import com.xyz.sql.query.api.service.SqlQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 通用数据查询API
 *
 * @author xyz
 * @date 2023/3/10
 */
@Api(value = "通用数据查询API", description = "通用数据查询API")
@RestController
@RequestMapping(value = "/sql/query")
public class SqlQueryController {

    @Resource
    private SqlQueryService sqlQueryService;

    @ApiOperation(value = "连接数据库")
    @PostMapping(value = "/connectDatabase")
    public DatabaseConnectResult connectDatabase(
            @ApiParam("连接参数") @RequestBody @Valid DatabaseConnectParam param,
            @ApiIgnore HttpSession session
    ) {
        return sqlQueryService.connectDatabase(param, session);
    }

    @ApiOperation(value = "查询表列信息")
    @GetMapping(value = "/table/columns")
    public List<ColumnInfo> queryTablesColumns(
            @ApiParam("表名") @RequestParam(value = "tableName", required = false, defaultValue = "") String tableName,
            @ApiIgnore HttpSession session
    ) {
        return sqlQueryService.queryTablesColumns(tableName, session);
    }

    @ApiOperation(value = "查询表数据列表")
    @PostMapping(value = "/table/dataList")
    public PageBack<Map<String, String>> queryTableDataList(
            @ApiParam("查询参数") @RequestBody @Valid DataListQueryParam param,
            @ApiIgnore HttpSession session
    ) {
        return sqlQueryService.queryTableDataList(param, session);
    }


}
