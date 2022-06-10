package com.galaxy.mercury.utils.web;

import com.galaxy.mercury.utils.Constants;
import com.galaxy.mercury.utils.SqlUtil;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.Map;

/**
 * controller 基类
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2021/11/3 18:22
 */

public class BaseController {
    /**
     * 设置请求分页数据
     *
     * @param param : 分页参数, 参考 - {@link PageInfo}
     * @author XianYao
     * @date 2021/12/22 21:39
     */
    protected void startPage(Map<String, Object> param) {
        PageInfo pageInfo = TableSupport.getPageInfo(param);
        Integer pageNum = pageInfo.getPageNum();
        Integer pageSize = pageInfo.getPageSize();

        String orderBy = SqlUtil.escapeOrderBySql(pageInfo.getOrderBy());
        Boolean reasonable = pageInfo.getReasonable();
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);

    }

    /**
     * 响应请求分页数据
     *
     * @param list: 分页数据
     * @return cn.com.venus.system.utils.web.JsonResult
     * @author XianYao
     * @date 2021/12/22 21:40
     */
    protected JsonResult getDataTable(List<?> list) {
        return JsonResult.ok(Constants.RESULT_OK_CODE, Constants.RESULT_OK_MSG, new com.github.pagehelper.PageInfo<>(list));
    }

}
