package com.mercury.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2022/5/9 12:01
 */
public class CommonTool {
    private static final Pattern HUMP_PATTERN = Pattern.compile("_(\\w)");
    private static final Pattern LINE_PATTERN = Pattern.compile("[A-Z]");

    /*public static void main(String[] args) {
        System.out.println(toHump("sys_user_admin"));
        System.out.println(toLine("sysUserAdmin"));
        System.out.println("parent_id".equalsIgnoreCase("parentId"));
    }*/

    /**
     * 下划线转驼峰
     *
     * @param str: 待转换字符串
     * @return java.lang.String
     * @author XianYao
     * @date 2022/5/9 12:12
     */
    public static String toHump(String str) {
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
    public static String toLine(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = LINE_PATTERN.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(0);
            matcher.appendReplacement(stringBuffer, "_" + group.toLowerCase());
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
