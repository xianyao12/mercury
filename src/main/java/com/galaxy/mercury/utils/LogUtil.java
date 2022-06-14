package com.galaxy.mercury.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志工具类
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2022/2/23 11:57
 */
public class LogUtil {
    public LogUtil() {
    }

    public static Logger getLogger() {
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        return LoggerFactory.getLogger(stacks[2].getClassName());
    }
}
