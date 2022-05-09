package com.mercury.utils.exception;

import com.mercury.utils.LogUtil;
import com.mercury.utils.web.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理器
 *
 * @author XianYao
 * @version V1.0
 * @date 2021/4/1 11:55
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 参数校验异常
     *
     * @param cve: 异常信息
     * @return cn.com.codetest.anduin.common.utils.web.JsonResult
     * @author XianYao
     * @date 2021/4/10 19:13
     */
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public JsonResult exceptionHandler(ConstraintViolationException cve, HttpServletRequest request, HttpServletResponse response) {
        LogUtil.getLogger().error("其他异常", cve);
        return JsonResult.error(500, "参数校验错误", cve.getMessage());
    }

    /**
     * 处理业务异常
     *
     * @param be: 异常信息
     * @return cn.com.codetest.anduin.common.utils.web.JsonResult
     * @author XianYao
     * @date 2021/4/12 18:28
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public JsonResult businessExceptionHandler(BusinessException be, HttpServletRequest request, HttpServletResponse response) {
        LogUtil.getLogger().error("其他异常", be);
        return JsonResult.error(be.getCode(), be.getMessage());
    }


}
