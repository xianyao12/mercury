package com.galaxy.mercury.utils.other;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author XianYao
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext ctx;

    /**
     * 功能:获取spring配置对象
     *
     * @param name 对象名
     * @return Object
     * @throws BeansException 自定义异常
     * @author chenjun
     * @date 2018-3-7
     */
    public static Object getBean(String name) throws BeansException {
        return ctx.getBean(name);
    }

    /**
     * 功能:获取spring配置对象
     *
     * @param name 对象名
     * @param cls  对象
     * @return T
     * @throws BeansException 自定义异常
     * @author chenjun
     * @date 2018-3-7
     */
    public static <T> T getBean(String name, Class<T> cls) throws BeansException {
        return ctx.getBean(name, cls);
    }

    /**
     * 功能:获取spring配置对象
     *
     * @param name 对象名
     * @param obj  对象
     * @return Object
     * @throws BeansException 自定义异常
     * @author chenjun
     * @date 2018-3-7
     */
    public static Object getBean(String name, Object obj) throws BeansException {
        return ctx.getBean(name, obj);
    }

    /**
     * 功能:获取spring配置对象
     *
     * @param cls 对象
     * @return T
     * @throws BeansException 自定义异常
     * @author chenjun
     * @date 2018-3-7
     */
    public static <T> T getBean(Class<T> cls) throws BeansException {
        return ctx.getBean(cls);
    }

    /**
     * 获取配置属性
     *
     * @param key 键
     * @return String
     * @author chenjun
     */
    public static String getEnvironmentProperty(String key) {
        return ctx.getEnvironment().getProperty(key);
    }

    /**
     * 获取配置属性
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return String
     * @author chenjun
     */
    public static String getEnvironmentProperty(String key, String defaultValue) {
        return ctx.getEnvironment().getProperty(key, defaultValue);
    }

    @Override
    public void setApplicationContext(@NotNull ApplicationContext ctx) throws BeansException {
        SpringContextUtil.ctx = ctx;
    }
}
