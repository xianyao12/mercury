package com.galaxy.mercury.common.aspect;

import com.galaxy.mercury.common.annotation.MethodTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 方法日志记录以及执行时间打印
 *
 * @author XianYao
 * @version V1.0
 * @date 2021/3/23 22:07
 */
@Component
@Aspect
public class MethodTimeAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* *..service..*(..))")
    public void point() {
    }

    @Around("@annotation(methodTime)")
    public Object doAround(ProceedingJoinPoint pjp, MethodTime methodTime) {
        long startTime = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            logger.error("方法执行时间统计注解错误, 错误概述:{},错误详情:{}", throwable.getMessage(), throwable.toString());
        }
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        logger.info("方法:[{}], 总计耗时: {}ms", methodName, endTime - startTime);
        return obj;
    }
}
