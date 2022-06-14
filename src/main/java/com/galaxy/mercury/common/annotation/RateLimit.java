package com.galaxy.mercury.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 限流注解
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2022/6/14 15:46
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimit {

    /**
     * 请求次数
     * <p>
     * 默认 1 秒内限制 10 次访问
     */
    int number() default 10;

    /**
     * 时间限制
     * <p>
     * 默认 1 秒内限制 10 次访问
     */
    long time() default 1;
}
