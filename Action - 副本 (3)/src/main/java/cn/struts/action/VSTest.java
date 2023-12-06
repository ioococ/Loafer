package cn.struts.action;

import com.opensymphony.xwork2.ActionSupport;

public class VSTest extends ActionSupport {
    private Product p;

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    @Override
    public String execute() {
        return SUCCESS;
    }
}
