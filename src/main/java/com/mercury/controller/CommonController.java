package com.mercury.controller;

import cn.hutool.core.convert.Convert;
import com.mercury.utils.web.BaseController;
import com.mercury.utils.web.JsonResult;
import org.jetbrains.annotations.NotNull;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 公共API
 *
 * @author XianYao
 * @version V1.0
 * @date 2021/12/22 22:13
 */
@RestController
@RequestMapping("/api/common")
public class CommonController extends BaseController {
    @Resource
    private SqlSessionTemplate st;

    /**
     * 获取表格数据
     *
     * @param param: 分页数据
     *               {
     *               pageNum:当前页,
     *               pageSize:每页的数量,
     *               orderByColumn:排序列,
     *               isAsc:排序的方向,
     *               reasonable:分页参数合理化,
     *               sqlId:sqlId,
     *               sqlParam:{sql参数}
     *               }
     * @return com.mercury.utils.web.JsonResult
     * @author XianYao
     * @date 2021/12/22 22:19
     */
    @PostMapping("/getGridData")
    public JsonResult getGridData(@RequestBody Map<String, Object> param) {
        startPage(param);
        List<Object> objects = st.selectList(Convert.toStr(param.get("sqlId")), param.get("sqlParam"));
        return getDataTable(objects);
    }

    /**
     * 获取数据
     *
     * @param param{ sqlId: sqlId,
     *               sqlParam: {sql参数}
     *               }: 参数
     * @return cn.com.venus.system.utils.web.JsonResult
     * @author XianYao
     * @date 2021/12/22 22:35
     */
    @PostMapping("/getData")
    public JsonResult getData(@RequestBody @NotNull Map<String, Object> param) {
        List<Object> objects = st.selectList(Convert.toStr(param.get("sqlId")), param.get("sqlParam"));
        return JsonResult.ok(objects);
    }
}
