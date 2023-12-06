package cn.itcast.action;

import JavaBean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NewLoginAction extends ActionSupport implements ModelDriven {
    private User user = new User();

    @Override
    public Object getModel() {
        return user;
    }
    @Override
    public String execute(){
        //获取 ActionContext(username password) 对象
        ActionContext 对象 = ActionContext.getContext();
        if (user.getUsername().equals("ZhangSan") && user.getPassword().equals("123456")) {
            对象.put("username",user.getUsername());
            对象.put("password",user.getPassword());
            对象.put("success","Login Success");
            对象.toString();
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            return SUCCESS;
        } else {
            对象.put("username",user.getUsername());
            对象.put("password",user.getPassword());
            对象.put("error","Login Error");
            对象.toString();
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            return ERROR;
        }
    }
}
