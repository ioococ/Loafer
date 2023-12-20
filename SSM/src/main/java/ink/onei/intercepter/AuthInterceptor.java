package ink.onei.intercepter;

import ink.onei.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 20/12/2023 19:52 Wednesday
 */

public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/signin.jsp");
            return false;
        } else {
            return super.preHandle(request, response, handler);
        }
    }
}
