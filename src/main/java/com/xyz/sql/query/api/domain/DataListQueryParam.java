package com.xyz.sql.query.api.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xyz
 * @date 2023/3/10
 */
@ApiModel
@Data
public class DataListQueryParam {

    @ApiModelProperty(value = "where条件")
    private String whereSql;

    @ApiModelProperty(value = "order条件")
    private String orderList;

    @ApiModelProperty(value = "页数")
    private int page;

    @ApiModelProperty(value = "页大小")
    private int pageSize;

}
