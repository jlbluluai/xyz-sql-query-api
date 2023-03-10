package com.xyz.sql.query.api.common.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页返回体
 *
 * @author xyz
 * @date 2019-09-26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageBack<T> {

    /**
     * 内容
     */
    private List<T> dataList;

    /**
     * 总页数
     */
    private Integer totalPages;

    /**
     * 总记录数
     */
    private Integer total;

}
