package com.coriander.common.entity;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author coriander
 */
@Getter
@Setter
public class PageDomain implements Serializable {
    private static final long serialVersionUID = 5661529086647172372L;

    /**
     * 当前记录起始索引
     */
    private Integer pageNum;

    /**
     * 每页显示记录数
     */
    private Integer pageSize;

    /**
     * 排序列
     */
    private String orderByColumn;

    /**
     * 排序的方向desc或者asc
     */
    private String isAsc = "asc";

    /**
     * 分页参数合理化
     */
    private Boolean reasonable = true;

    public String getOrderBy() {
        if (StrUtil.isBlank(orderByColumn)) {
            return "";
        }
        return StrUtil.toUnderlineCase((orderByColumn) + " " + isAsc);
    }

    public void setIsAsc(String isAsc) {
        if (StrUtil.isNotBlank(isAsc)) {
            // 兼容前端排序类型
            if ("ascending".equals(isAsc)) {
                isAsc = "asc";
            } else if ("descending".equals(isAsc)) {
                isAsc = "desc";
            }
            this.isAsc = isAsc;
        }
    }

    public Boolean getReasonable() {
        if (reasonable == null) {
            return Boolean.TRUE;
        }
        return reasonable;
    }
}
