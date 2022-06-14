package com.galaxy.mercury.common.config;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.MapWrapper;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字段大写转小写
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2021/12/23 18:47
 */
public class MybatisCamelCase extends MapWrapper {
    private static final Pattern linePattern = Pattern.compile("_(\\w)");

    public MybatisCamelCase(MetaObject metaObject, Map<String, Object> map) {
        super(metaObject, map);
    }

    public static String toCamelCase(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public String findProperty(String name, boolean useCamelCaseMapping) {
        return useCamelCaseMapping ? toCamelCase(name) : name.toLowerCase();
    }

    public void set(PropertyTokenizer prop, Object value) {
        if (value instanceof Clob) {
            Clob c = (Clob) value;
            try {
                value = c.getSubString(1L, Long.valueOf(c.length()).intValue());
            } catch (SQLException var5) {
                var5.printStackTrace();
            }
        }

        super.set(prop, value);
    }
}
