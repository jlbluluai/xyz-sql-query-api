package com.xyz.sql.query.api.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 数据库连接结果信息
 *
 * @author xyz
 * @date 2023/3/10
 */
@Data
@ApiModel
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseConnectResult {

    @ApiModelProperty(value = "表列表")
    public List<TableInfo> tables;

}
