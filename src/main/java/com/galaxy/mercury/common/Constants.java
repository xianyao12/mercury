package com.galaxy.mercury.common;

/**
 * 系统常量
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2022/6/2 11:49
 */
public class Constants {
    /**
     * 默认成功码
     */
    public static final int RESULT_OK_CODE = 0;
    /**
     * 默认失败码
     */
    public static final int RESULT_ERROR_CODE = 1;
    /**
     * 默认成功信息
     */
    public static final String RESULT_OK_MSG = "操作成功";
    /**
     * 默认失败信息
     */
    public static final String RESULT_ERROR_MSG = "操作失败";

    /**
     * 登录
     */
    public static final int TYPE_LOGIN = 0;
    /**
     * 登录失败
     */
    public static final int TYPE_ERROR = 1;
    /**
     * 退出登录
     */
    public static final int TYPE_LOGOUT = 2;
    /**
     * 登录过期
     */
    public static final int TYPE_REFRESH = 3;
    /**
     * 异地登录
     */
    public static final int TYPE_REMOTE_LOGIN = 4;
    /**
     * 被管理员强制下线
     */
    public static final int TYPE_FORCED_OUT = 5;
}
