package app.usermanager.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 04/12/2023 09:26 Monday
 */


public class EncodingFilter extends HttpFilter {
    @Serial
    private static final long serialVersionUID = -6328015927157288073L;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resq, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resq.setCharacterEncoding("UTF-8");
        super.doFilter(req, resq, chain);
        System.out.println("doFilter() 方法");
    }
}
