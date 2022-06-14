package com.galaxy.mercury.common.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galaxy.mercury.common.Constants;
import com.galaxy.mercury.common.annotation.NotControllerResponse;
import com.galaxy.mercury.common.exception.BusinessCustomException;
import com.galaxy.mercury.common.web.JsonResult;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 请求响应封装
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2022/6/13 11:03
 */
@RestControllerAdvice
public class ControllerResponseInterceptor implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(@NotNull MethodParameter returnType,
                            @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        // response 是 JsonResult 类型，或者添加了 NotControllerResponseAdvice 注解的不进行封装
        return !returnType.getParameterType().isAssignableFrom(JsonResult.class)
                && !returnType.hasMethodAnnotation(NotControllerResponse.class);
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  @NotNull MethodParameter returnType,
                                  @NotNull MediaType selectedContentType,
                                  @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  @NotNull ServerHttpRequest request,
                                  @NotNull ServerHttpResponse response) {
        // String 类型不能直接包装
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 把数据包装到 JsonResult 再返回
                return objectMapper.writeValueAsString(JsonResult.ok(body));
            } catch (JsonProcessingException e) {
                throw new BusinessCustomException(Constants.RESULT_ERROR_CODE, e.getMessage());
            }
        }
        // 否则直接包装成 JsonResult 返回
        return JsonResult.ok(body);
    }
}
