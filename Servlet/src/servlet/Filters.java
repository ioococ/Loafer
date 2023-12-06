package servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "Filter")
public class Filters implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //此处字符集设置后，此后的Servlet不再重复
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
    }
}
