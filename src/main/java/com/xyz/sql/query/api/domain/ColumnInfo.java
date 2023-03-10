package com.xyz.sql.query.api.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 列信息
 *
 * @author xyz
 * @date 2023/3/10
 */
@ApiModel
@Data
public class ColumnInfo {

    @ApiModelProperty("列名")
    private String columnName;

    @ApiModelProperty("列描述")
    private String columnDesc;

}
