package com.galaxy.mercury.common.web;

import cn.hutool.core.convert.Convert;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * 表格数据处理
 *
 * @author XianYao
 * @version V1.0
 * @date 2021/12/22 20:56
 */
public class TableSupport {
    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 desc 或者 asc
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 分页参数合理化
     */
    public static final String REASONABLE = "reasonable";

    /**
     * 封装分页对象
     *
     * @param param: 分页数据
     * @return com.galaxy.mercury.common.web.PageInfo
     * @author XianYao
     * @date 2021/12/22 21:41
     */
    public static @NotNull PageInfo getPageInfo(@NotNull Map<String, Object> param) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(Convert.toInt(param.get(PAGE_NUM), 0));
        pageInfo.setPageSize(Convert.toInt(param.get(PAGE_SIZE), 10));
        pageInfo.setOrderByColumn(Convert.toStr(param.get(ORDER_BY_COLUMN)));
        pageInfo.setIsAsc(Convert.toStr(param.get(IS_ASC)));
        pageInfo.setReasonable(Convert.toBool(param.get(REASONABLE), true));
        return pageInfo;
    }

}
