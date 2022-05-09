package com.mercury.utils;

import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取客户端设备信息工具类
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2022/1/5 11:00
 */
public class ClientMessageUtil {
    private final UserAgent userAgent;
    private final String userAgentString;
    private final HttpServletRequest userRequest;

    public ClientMessageUtil(HttpServletRequest request) {
        this.userRequest = request;
        this.userAgentString = request.getHeader("User-Agent");
        this.userAgent = UserAgent.parseUserAgentString(userAgentString);
    }

    /**
     * 获取ip地址
     */
    public static String getIp(HttpServletRequest request) {
        String ip = null;
        try {
            ip = request.getHeader("x-forwarded-for");
            if (isBlankIp(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (isBlankIp(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (isBlankIp(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (isBlankIp(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (isBlankIp(ip)) {
                ip = request.getRemoteAddr();
            }
            // 多个ip获取第一个
            if (!isBlankIp(ip) && ip.length() > 15) {
                ip = ip.split(",")[0];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return ip;
    }

    private static boolean isBlankIp(String ip) {
        return ip == null || ip.trim().isEmpty() || "unknown".equalsIgnoreCase(ip);
    }

    /**
     * 获取浏览器类型
     */
    public String getBrowser() {
        if (null == userAgent) {
            return "Unknown";
        }
        return userAgent.getBrowser().getName();
    }

    /**
     * 获取操作系统
     */
    public String getOS() {
        if (null == userAgent) {
            return "Unknown";
        }
        return userAgent.getOperatingSystem().getName();
    }

    /**
     * 获取设备型号
     */
    public String getDevice() {
        if (null == userAgentString) {
            return "Unknown";
        } else if (userAgentString.contains("Android")) {
            String[] str = userAgentString.split("[()]+");
            str = str[1].split("[;]");
            String[] res = str[str.length - 1].split("Build/");
            return res[0].trim();
        } else if (userAgentString.contains("iPhone")) {
            String[] str = userAgentString.split("[()]+");
            String res = "iphone" + str[1].split("OS")[1].split("like")[0];
            return res.trim();
        } else if (userAgentString.contains("iPad")) {
            return "iPad";
        } else {
            return userAgentString;
        }
    }

    /**
     * 获取ip地址
     */
    public String getIp() {
        return getIp(userRequest);
    }
}
