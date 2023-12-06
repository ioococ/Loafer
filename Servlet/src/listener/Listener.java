package listener;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.util.LinkedList;
import java.util.List;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private ServletContext application = null;

    public Listener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        //初始化一个application对象
        this.application = sce.getServletContext();
        //设置一个列表属性，保存在线用户名
        this.application.setAttribute("online",new LinkedList<String>());

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        //用户注销

        //取Session中的用户列表
        List<String> online = (List<String>) this.application.getAttribute("online");
        String username = (String) se.getSession().getAttribute("username");
        online.remove(username);
        this.application.setAttribute("online",online);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
        //获取用户列表
        List<String> online = (List<String>) this.application.getAttribute("online");
        if ("username".equals(sbe.getName())){
            online.add((String) sbe.getValue());//将当前登录的用户名放入列表中
        }
        this.application.setAttribute("online",online);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
