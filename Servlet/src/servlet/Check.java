package servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "Check")
public class Check implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password1 = request.getParameter("password");
        System.out.println(name+"="+password1);
        if (name != null) {
            if (!(name.trim().equals("Super") && password1.trim().equals("Super"))) {
                response.getWriter().write("<p>输入错误</p>");
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
