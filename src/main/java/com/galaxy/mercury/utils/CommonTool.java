package com.galaxy.mercury.utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 公共方法
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2022/5/9 12:01
 */
public class CommonTool {
    private static final Pattern HUMP_PATTERN = Pattern.compile("_(\\w)");
    private static final Pattern LINE_PATTERN = Pattern.compile("[A-Z]");

    /**
     * 下划线转驼峰
     *
     * @param str: 待转换字符串
     * @return java.lang.String
     * @author XianYao
     * @date 2022/5/9 12:12
     */
    public static @NotNull String toHump(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = HUMP_PATTERN.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            matcher.appendReplacement(stringBuffer, group.toUpperCase());
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /**
     * 驼峰转下划线并转小写
     *
     * @param str: 待转换字符串
     * @return java.lang.String
     * @author XianYao
     * @date 2022/5/9 12:21
     */
    public static @NotNull String toLine(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = LINE_PATTERN.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(0);
            matcher.appendReplacement(stringBuffer, "_" + group.toLowerCase());
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /**
     * 去空格
     *
     * @param str: 字符串
     * @return 去除空格后的字符串
     * @author XianYao
     * @date 2022/6/20 19:01
     */
    @Contract(pure = true)
    public static @NotNull String removeSpaces(String str) {
        return (str == null ? "" : str.trim());
    }
}
