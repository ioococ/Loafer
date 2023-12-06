package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

public class AwareAction extends ActionSupport implements ServletRequestAware {
    HttpServletRequest request;

    @Override
    public void setServletRequest(javax.servlet.http.HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String execute() {
        request.setAttribute("message","By ServletRequestAware access ServletAPI" +
                "读取出动作pojo在request对象中写入的Message");
        return SUCCESS;
    }
}
