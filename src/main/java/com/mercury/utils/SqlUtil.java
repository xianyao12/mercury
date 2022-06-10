package com.mercury.utils;

import cn.hutool.core.util.StrUtil;

import java.util.regex.Pattern;

/**
 * sql操作工具类
 *
 * @author XianYao
 * @version V1.0
 * @date 2021/12/22 20:57
 */
public class SqlUtil {

    /**
     * 过滤掉的sql关键字，特殊字符前面需要加\\进行转义
     */
    private static final String REGEX = "select|update|and|or|delete|insert|truncate|char|into|substr|ascii|declare|" +
            "exec|count|master|drop|execute|table|sitename|xp_cmdshell|like|from|grant|use|group_concat|column_name|" +
            "information_schema.columns|table_schema|union|where|order|by|'\\*|;|-|--|\\+|,|//|/|%|#|" +
            "'|(/\\*(?:.|[\\n\\r])*?\\*/)";
    private static final Pattern SQL_PATTERN = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);

    /**
     * mybatis 动态参数强制校验
     */
    public static boolean check(Object param) {
        String checkParam = String.valueOf(param);
        return !(checkParam == null || checkParam.isEmpty()) && !SQL_PATTERN.matcher(checkParam).find();
    }

    /**
     * 检查字符，防止注入绕过
     */
    public static String escapeOrderBySql(String value) {
        if (!StrUtil.isEmpty(value) && isValidOrderBySql(value)) {
            throw new IllegalArgumentException("参数存在SQL注入漏洞，不能进行查询");
        }
        return value;
    }

    /**
     * 验证 order by 语法是否符合规范
     */
    public static boolean isValidOrderBySql(String value) {
        return SQL_PATTERN.matcher(value).find();
    }
}
