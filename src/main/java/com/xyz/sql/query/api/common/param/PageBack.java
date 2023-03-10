package com.xyz.sql.query.api.common.param;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Supplier;

/**
 * 分页返回体
 *
 * @author xyz
 * @date 2019-09-26
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBack<T> {

    /**
     * 内容
     */
    private List<T> resultList;

    /**
     * 总页数
     */
    private Integer totalPages;

    /**
     * 总记录数
     */
    private Integer total;

    public static <S, G> PageBack<G> buildPageBack(PageInfo<S> pageInfo, Supplier<List<G>> target) {
        PageBack<G> pageBack = new PageBack<>();
        pageBack.setResultList(target.get());
        pageBack.setTotalPages(pageInfo.getPages());
        pageBack.setTotal((int) pageInfo.getTotal());
        return pageBack;
    }

}
