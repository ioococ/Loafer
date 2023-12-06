package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute(){
        //获取 ActionContext(username password) 对象
        ActionContext 对象 = ActionContext.getContext();
        if (username.equals("ZhangSan") && password.equals("123456")) {
            对象.put("username",username);
            对象.put("password",password);
            对象.put("success","Login Success");
            对象.toString();
            System.out.println(username);
            System.out.println(password);
            return SUCCESS;
        } else {
            对象.put("username",username);
            对象.put("password",password);
            对象.put("error","Login Error");
            对象.toString();
            System.out.println(username);
            System.out.println(password);
            return ERROR;
        }
    }
}
