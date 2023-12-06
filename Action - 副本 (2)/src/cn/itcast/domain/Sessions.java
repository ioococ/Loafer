package cn.itcast.domain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

public class Sessions {
    private HttpServletRequest request;
    public void gets() {
        //获取session
        HttpSession session = request.getSession();
        // 获取session中所有的键值
        Enumeration<String> enumeration = session.getAttributeNames();
        // 遍历attrs中的
        while (enumeration.hasMoreElements()) {
            // 获取session键值
            String name = enumeration.nextElement();
            // 根据键值取session中的值
            Object value = session.getAttribute(name);
            // 打印结果
            System.out.println("------" + name + ":" + value + "--------\n");
        }
    }
}
