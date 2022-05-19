package com.mercury.utils.web;

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

    private final static int SUCCESS_CODE = 0;
    private final static String SUCCESS_MSG = "请求成功";
    private final static int ERROR_CODE = 1;
    private final static String ERROR_MSG = "请求失败";

    public JsonResult() {
    }

    public static JsonResult ok() {
        JsonResult r = new JsonResult();
        r.put("code", SUCCESS_CODE);
        r.put("msg", SUCCESS_MSG);
        return r;
    }

    public static JsonResult ok(Object data) {
        JsonResult r = new JsonResult();
        r.put("code", SUCCESS_CODE);
        r.put("msg", SUCCESS_MSG);
        r.put("data", data);
        return r;
    }

    public static JsonResult ok(Integer code, String msg) {
        JsonResult r = new JsonResult();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static JsonResult ok(Integer code, String msg, Object data) {
        JsonResult r = new JsonResult();
        r.put("code", code);
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }

    public static JsonResult error() {
        JsonResult r = new JsonResult();
        r.put("code", ERROR_CODE);
        r.put("msg", ERROR_MSG);
        return r;
    }

    public static JsonResult error(Object data) {
        JsonResult r = new JsonResult();
        r.put("code", ERROR_CODE);
        r.put("msg", ERROR_MSG);
        r.put("data", data);
        return r;
    }

    public static JsonResult error(Integer code, String msg) {
        JsonResult r = new JsonResult();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }


    public static JsonResult error(Integer code, Exception exc) {
        JsonResult r = new JsonResult();
        r.put("code", code);
        r.put("msg", exc.getMessage());
        return r;
    }

    public static JsonResult error(Integer code, String msg, Object data) {
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
