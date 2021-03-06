package com.galaxy.mercury.common.exception;

/**
 * 业务异常
 *
 * @author XianYao
 * @version V1.0
 * @date 2021/4/1 11:55
 */
public class BusinessCustomException extends BaseCustomException {
    private static final long serialVersionUID = 5450935008012318697L;

    public BusinessCustomException() {
        super();
    }

    public BusinessCustomException(String message) {
        super(message);
    }

    public BusinessCustomException(Integer code, String message) {
        super(code, message);
    }

    @Override
    public Integer getCode() {
        Integer code = super.getCode();
        if (code == null) {
            code = 500;
        }
        return code;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "系统错误";
        }
        return message;
    }
}
