package com.xyz.sql.query.api.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表信息
 *
 * @author xyz
 * @date 2023/3/10
 */
@ApiModel
@Data
public class TableInfo {

    @ApiModelProperty("表名")
    private String tableName;

    @ApiModelProperty("表描述")
    private String tableDesc;
}
