package com.mercury.utils.web;

import com.github.pagehelper.PageHelper;
import com.mercury.utils.SqlUtil;
import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;
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
    @Resource
    private SqlSessionTemplate st;

    /**
     * 设置请求分页数据
     *
     * @param param: 分页参数
     * @author XianYao
     * @date 2021/12/22 21:39
     */
    protected void startPage(Map<String, Object> param) {
        PageInfo pageInfo = TableSupport.getPageInfo(param);
        Integer pageNum = pageInfo.getPageNum();
        Integer pageSize = pageInfo.getPageSize();
        if (pageNum != null && pageSize != null) {
            String orderBy = SqlUtil.escapeOrderBySql(pageInfo.getOrderBy());
            Boolean reasonable = pageInfo.getReasonable();
            PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
        }

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
        return JsonResult.ok(0, "查询成功", new com.github.pagehelper.PageInfo<>(list));
    }

    /**
     * 获取当前登录的user
     *
     * @author XianYao
     * @date 2021/7/13 22:01
     */
    public Map<String, Object> getLoginUser(Object userId) {
        return st.selectOne("main.getFullById", userId);
    }
}
