package com.coriander.common.entity;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author coriander
 */
@Getter
@Setter
public class PageLight<T> implements Serializable {
    private static final long serialVersionUID = 5865250330571801592L;

    /**
     * 总记录数
     */
    private long total;
    /**
     * 列表数据
     */
    private List<T> rows;

    public PageLight() {
    }


    @SuppressWarnings("unchecked")
    public PageLight(List<?> list) {
        PageInfo<?> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        this.rows = (List<T>) pageInfo.getList();
    }

}
