package com.xyz.sql.query.api.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 数据库连接参数
 *
 * @author xyz
 * @date 2023/3/10
 */
@Data
@ApiModel
public class DatabaseConnectParam {

    @ApiModelProperty("Host")
    @NotBlank(message = "host不得为空")
    private String host;

    @ApiModelProperty("Port")
    @NotBlank(message = "port不得为空")
    private String port;

    @ApiModelProperty("User")
    @NotBlank(message = "user不得为空")
    private String user;

    /**
     * todo 后期传输改成加密
     */
    @ApiModelProperty("Password")
    @NotBlank(message = "password不得为空")
    private String password;

    @ApiModelProperty("Database")
    @NotBlank(message = "database不得为空")
    private String database;

}
