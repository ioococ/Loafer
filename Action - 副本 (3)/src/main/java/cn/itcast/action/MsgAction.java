package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;

public class MsgAction extends ActionSupport {
    public String execute(){
        this.addActionError("Action Error");
        this.addActionMessage("Action Message");
        this.addFieldError("msg","Action Field Error");
        return null;
    }
}
