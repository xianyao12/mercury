package com.galaxy.mercury.utils.web;

import com.galaxy.mercury.utils.Constants;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * json 返回值
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2021/11/3 18:20
 */
public class JsonResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public JsonResult() {
    }

    public static @NotNull JsonResult ok() {
        JsonResult r = new JsonResult();
        r.put("code", Constants.RESULT_OK_CODE);
        r.put("msg", Constants.RESULT_OK_MSG);
        return r;
    }

    public static @NotNull JsonResult ok(Object data) {
        JsonResult r = new JsonResult();
        r.put("code", Constants.RESULT_OK_CODE);
        r.put("msg", Constants.RESULT_OK_MSG);
        r.put("data", data);
        return r;
    }

    public static @NotNull JsonResult ok(Integer code, String msg) {
        JsonResult r = new JsonResult();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static @NotNull JsonResult ok(Integer code, String msg, Object data) {
        JsonResult r = new JsonResult();
        r.put("code", code);
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }

    public static @NotNull JsonResult error() {
        JsonResult r = new JsonResult();
        r.put("code", Constants.RESULT_ERROR_CODE);
        r.put("msg", Constants.RESULT_ERROR_MSG);
        return r;
    }

    public static @NotNull JsonResult error(Object data) {
        JsonResult r = new JsonResult();
        r.put("code", Constants.RESULT_ERROR_CODE);
        r.put("msg", Constants.RESULT_ERROR_MSG);
        r.put("data", data);
        return r;
    }

    public static @NotNull JsonResult error(Integer code, String msg) {
        JsonResult r = new JsonResult();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static @NotNull JsonResult error(Integer code, Exception exc) {
        JsonResult r = new JsonResult();
        r.put("code", code);
        r.put("msg", exc.getMessage());
        return r;
    }

    public static @NotNull JsonResult error(Integer code, String msg, Object data) {
        JsonResult r = new JsonResult();
        r.put("code", code);
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }

    /**
     * put其他数据，支持链式写法
     *
     * @param key  其他数据键值
     * @param data 数据
     * @return JsonResult
     * @author XianYao
     * @date 2020/4/11 19:04
     */
    @Override
    public JsonResult put(String key, Object data) {
        super.put(key, data == null ? "" : data);
        return this;
    }

    public Integer getCode(int code) {
        Object o = get("code");
        return o == null ? null : Integer.parseInt(o.toString());
    }

    public JsonResult setCode(Integer code) {
        return put("code", code);
    }

    public String getMsg() {
        Object o = get("msg");
        return o == null ? null : o.toString();
    }

    public JsonResult setMsg(String msg) {
        return put("msg", msg);
    }

    public Object getData() {
        return get("data");
    }

    public JsonResult setData(Object object) {
        return put("data", object);
    }
}
