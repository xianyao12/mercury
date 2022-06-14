package com.galaxy.mercury.common.annotation;

import java.lang.annotation.*;

/**
 * 方法执行时间统计注解
 *
 * @author XianYao
 * @version V1.0
 * @date 2021/7/15 16:15
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MethodTime {
}
