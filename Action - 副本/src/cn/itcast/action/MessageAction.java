package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class MessageAction extends ActionSupport {
    HttpServletRequest request;
    @Override
    public String execute(){
        request = ServletActionContext.getRequest();
        request.setAttribute("message","通过ServLetActionContext对象的getRequest获取");
        return SUCCESS;
    }
}

