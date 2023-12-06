package cn.itcast.interceptor;

import cn.itcast.domain.Sessions;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Privilege implements Interceptor {
//public class Privilege extends AbstractInterceptor {

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext ac = actionInvocation.getInvocationContext();
        Object user = ac.getSession().get("user"); //取session中的user
        if (user != null){ //如果不为空 说明在执行BookAction前进行过登录动作（LoginAction）
            user.toString();
            return actionInvocation.invoke(); //继续向下执行
        } else{
            ac.put("msg","Please Login");
            return Action.LOGIN;
        }
    }
}
