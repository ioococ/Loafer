package com.my.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class BBeanFactory {
    public static BookDao getBean;


    public static BookDao getBean() {
        //准备目标类
        final BookDao bookDao = new BookDao();
        //准备切面类
        final BAspect bAspect = new BAspect();
        //生成代理 进行整合
        Enhancer enhancer = new Enhancer();//核心类
        //确定需要增强的类
        enhancer.setSuperclass(bookDao.getClass());
        enhancer.setCallback(
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        BAspect.before();
                        Object obj = method.invoke(bookDao,objects);
                        BAspect.after();
                        return obj;
                    }
                }
        );
        //
        //创建代理类
        BookDao bookDaoProxy = (BookDao) enhancer.create();
        return bookDaoProxy;
    }
}
