package cn.sierac.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Jack on 2017/7/27.
 */
public class ValidateToken {
    public static boolean isToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String token = "";
        String stoken = "";
        if (session.getAttribute("sessionToken") != null)
            stoken = session.getAttribute("sessionToken").toString();
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (int i = 0; i < cookie.length; i++) {
                Cookie cook = cookie[i];
                if (cook.getName().equalsIgnoreCase("cookieToken")) { // 获取键
                    token = cook.getValue().toString();
                }
            }
        }
        if (stoken.equals(token) && stoken != "") {
            return true;
        }
        return false;
    }
}
