package com.galaxy.mercury.utils.web;

import cn.hutool.core.util.StrUtil;
import com.galaxy.mercury.utils.other.CommonTool;

import javax.validation.constraints.NotNull;

/**
 * 分页数据
 *
 * @author XianYao
 * @version V1.0
 * @date 2021/12/22 20:55
 */
public class PageInfo {
    /**
     * 当前记录起始索引
     */
    @NotNull(message = "页码不能为空")
    private Integer pageNum;

    /**
     * 每页显示记录数
     */
    @NotNull(message = "每页显示记录数不能为空")
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

    public PageInfo() {
    }

    public String getOrderBy() {
        if (StrUtil.isEmpty(orderByColumn)) {
            return "";
        }
        return CommonTool.toLine(orderByColumn) + " " + isAsc;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    public String getIsAsc() {
        return isAsc;
    }

    public void setIsAsc(String isAsc) {
        if (!StrUtil.isEmpty(isAsc)) {
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

    public void setReasonable(Boolean reasonable) {
        this.reasonable = reasonable;
    }
}
