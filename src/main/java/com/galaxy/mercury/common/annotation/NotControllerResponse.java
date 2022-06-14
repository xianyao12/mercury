package com.galaxy.mercury.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 拒绝请求响应封装
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2022/6/13 11:18
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotControllerResponse {
}
