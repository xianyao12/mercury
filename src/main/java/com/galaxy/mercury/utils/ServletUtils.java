package com.galaxy.mercury.utils;

import cn.hutool.core.convert.Convert;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 客户端工具类
 *
 * @author XianYao
 * @version V1.0
 * @date 2021/12/22 20:51
 */
public class ServletUtils {

    /**
     * 获取request
     *
     * @return HttpServletRequest
     * @author XianYao
     * @date 2022/6/20 18:56
     */
    public static @NotNull HttpServletRequest getRequest() {

        return getRequestAttributes().getRequest();
    }

    /**
     * 获取response
     *
     * @return HttpServletResponse
     * @author XianYao
     * @date 2022/6/20 18:57
     */
    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    /**
     * 获取session
     *
     * @return HttpSession
     * @author XianYao
     * @date 2022/6/20 18:57
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取客户端IP地址
     *
     * @return 客户端IP地址
     * @author XianYao
     * @date 2022/6/20 18:57
     */
    public static String getIpAddress() {
        HttpServletRequest request = getRequest();
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if ("127.0.0.1".equals(ipAddress) || "0:0:0:0:0:0:0:1".equals(ipAddress)) {
                // 根据网卡取本机配置的IP
                try {
                    ipAddress = InetAddress.getLocalHost().getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * 获取请求属性
     *
     * @return ServletRequestAttributes
     * @author XianYao
     * @date 2022/6/20 18:58
     */
    public static ServletRequestAttributes getRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /**
     * 将字符串渲染到客户端
     *
     * @param response: 渲染对象
     * @param string:   待渲染的字符串
     * @author XianYao
     * @date 2022/6/20 18:59
     */
    public static void renderString(@NotNull HttpServletResponse response, String string) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 是否是Ajax异步请求
     *
     * @param request: 请求体
     * @return boolean
     * @author XianYao
     * @date 2022/6/20 18:59
     */
    public static boolean isAjaxRequest(@NotNull HttpServletRequest request) {
        String accept = request.getHeader("accept");
        if (accept != null && accept.contains("application/json")) {
            return true;
        }
        String xRequestedWith = request.getHeader("X-Requested-With");
        if (xRequestedWith != null && xRequestedWith.contains("XMLHttpRequest")) {
            return true;
        }
        String uri = request.getRequestURI();
        if (inStringIgnoreCase(uri, ".json", ".xml")) {
            return true;
        }
        String ajax = request.getParameter("__ajax");
        return inStringIgnoreCase(ajax, "json", "xml");
    }

    /**
     * 是否包含字符串
     *
     * @param str:  验证字符串
     * @param strs: 字符串组
     * @return boolean
     * @author XianYao
     * @date 2022/6/20 19:00
     */
    public static boolean inStringIgnoreCase(String str, String... strs) {
        if (str != null && strs != null) {
            for (String s : strs) {
                if (str.equalsIgnoreCase(CommonTool.removeSpaces(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取String参数
     *
     * @param name: 名字
     * @return java.lang.String
     * @author XianYao
     * @date 2022/6/20 12:46
     */
    public static String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    /**
     * 获取String参数
     *
     * @param name:         参数名
     * @param defaultValue: 默认值
     * @return java.lang.String
     * @author XianYao
     * @date 2022/6/20 19:03
     */
    public static String getParameter(String name, String defaultValue) {
        return Convert.toStr(getRequest().getParameter(name), defaultValue);
    }

    /**
     * 获取Integer参数
     *
     * @param name: 参数名
     * @return java.lang.Integer
     * @author XianYao
     * @date 2022/6/20 19:04
     */
    public static Integer getParameterToInt(String name) {
        return Convert.toInt(getRequest().getParameter(name));
    }

    /**
     * 获取Integer参数
     *
     * @param name:         参数名
     * @param defaultValue: 默认值
     * @return java.lang.Integer
     * @author XianYao
     * @date 2022/6/20 19:05
     */
    public static Integer getParameterToInt(String name, Integer defaultValue) {
        return Convert.toInt(getRequest().getParameter(name), defaultValue);
    }

    /**
     * 获取Boolean参数
     *
     * @param name: 参数名
     * @return java.lang.Boolean
     * @author XianYao
     * @date 2022/6/20 19:05
     */
    public static Boolean getParameterToBool(String name) {
        return Convert.toBool(getRequest().getParameter(name));
    }

    /**
     * 获取Boolean参数
     *
     * @param name:         参数名
     * @param defaultValue: 默认值
     * @return java.lang.Boolean
     * @author XianYao
     * @date 2022/6/20 19:05
     */
    public static Boolean getParameterToBool(String name, Boolean defaultValue) {
        return Convert.toBool(getRequest().getParameter(name), defaultValue);
    }

}
