package cn.itcast.action;

import cn.itcast.domain.Sessions;
import cn.itcast.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven {
    private User user = new User();
    @Override
    public User getModel() {
        return user;
    }

    public String execute() {
        ActionContext ac = ActionContext.getContext();
        if ("ZhangSan".equals(user.getUsername()) && "123456".equals(user.getPassword())) {
            ac.getSession().put("user", user);
            ac.getSession().put("user", user);
            return SUCCESS;
        } else {
            ac.put("Message", "Error");
            return INPUT;
        }
    }


}
