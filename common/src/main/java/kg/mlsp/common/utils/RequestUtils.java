package kg.mlsp.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;


public class RequestUtils {

    private static final String IP_V6_LOCALHOST = "0:0:0:0:0:0:0:1";
    private static final String IP_V4_LOCALHOST = "127.0.0.1";

    public static String getClientIp() {
        ServletRequestAttributes attrs =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attrs == null) {
            return "UNKNOWN";
        }

        HttpServletRequest request = attrs.getRequest();
        String xfHeader = request.getHeader("X-Forwarded-For");

        String ip = (xfHeader == null) ? request.getRemoteAddr() : xfHeader.split(",")[0].trim();

        if (IP_V6_LOCALHOST.equals(ip)) {
            ip = IP_V4_LOCALHOST; // normalize IPv6 localhost
        }

        return ip;
    }

}
