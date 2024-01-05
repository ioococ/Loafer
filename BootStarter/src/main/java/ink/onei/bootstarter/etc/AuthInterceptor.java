package ink.onei.bootstarter.etc;

import ink.onei.bootstarter.etc.Constants;
import ink.onei.bootstarter.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 05/01/2024 16:22 Friday
 */

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.LOGIN_USER_SESSION_KEY);
        if (user == null){
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        } else
            return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
