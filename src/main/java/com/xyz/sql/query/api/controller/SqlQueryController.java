package com.xyz.sql.query.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * 通用数据查询API
 *
 * @author xyz
 * @date 2023/3/10 14:55
 */
@Api(value = "通用数据查询API", description = "通用数据查询API")
@RestController
@RequestMapping(value = "/sql/query")
public class SqlQueryController {

    @ApiOperation(value = "查询表列信息")
    @GetMapping(value = "/table/fileds")
    public List<String> queryTablesFiles(
            @ApiParam("表名") @RequestParam(value = "tableName", required = false, defaultValue = "") String tableName
    ) {

        return Collections.emptyList();
    }


}
