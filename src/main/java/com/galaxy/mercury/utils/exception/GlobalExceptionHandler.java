package com.galaxy.mercury.utils.exception;

import com.galaxy.mercury.utils.LogUtil;
import com.galaxy.mercury.utils.web.JsonResult;
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

    /**
     * 参数校验异常
     *
     * @param cve: 异常信息
     * @return JsonResult
     * @author XianYao
     * @date 2021/4/10 19:13
     */
    @ResponseBody
    @ExceptionHandler(value = {IllegalArgumentException.class, ConstraintViolationException.class})
    public JsonResult exceptionHandler(ConstraintViolationException cve, HttpServletRequest request, HttpServletResponse response) {
        LogUtil.getLogger().error("参数校验异常", cve);
        return JsonResult.error(500, "参数校验错误", cve.getMessage());
    }

    /**
     * 业务异常
     *
     * @param be: 异常信息
     * @return JsonResult
     * @author XianYao
     * @date 2021/4/12 18:28
     */
    @ResponseBody
    @ExceptionHandler(BusinessCustomException.class)
    public JsonResult businessExceptionHandler(BusinessCustomException be, HttpServletRequest request, HttpServletResponse response) {
        LogUtil.getLogger().error("业务异常", be);
        return JsonResult.error(be.getCode(), be.getMessage());
    }


}
