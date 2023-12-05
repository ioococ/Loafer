package com.my.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
    public static UserDao getBean() {
        //准备目标类（Spring创建对象 IoC）
        final UserDao userDao = new UDImp();
        //创建切面实例
        final Aspect aspect = new Aspect();
        //使用代理类进行增强
        return (UserDao) Proxy.newProxyInstance(
                BeanFactory.class.getClassLoader(),
                new Class[]{UserDao.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aspect.before();
                        Object obj = method.invoke(userDao, args);
                        aspect.after();
                        return obj;
                    }
                }
        );
    }
}
