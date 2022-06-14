package com.galaxy.mercury.common.exception;

/**
 * 自定义异常基类
 *
 * @author XianYao
 * @version V1.0
 * @date 2021/4/1 11:55
 */
public abstract class BaseCustomException extends RuntimeException {
    private static final long serialVersionUID = -1582874427218948396L;
    private Integer code;

    public BaseCustomException() {
    }

    public BaseCustomException(String message) {
        super(message);
    }

    public BaseCustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
