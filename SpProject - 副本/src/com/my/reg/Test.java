package com.my.reg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void cure() {
        //指定配置文件
        String XmlFile = "applicationContext.xml";
        //加载配置文件 初始化Spring
        ApplicationContext aC = new ClassPathXmlApplicationContext(XmlFile);
        //通过实例获得UserService方法
        H h = (H) aC.getBean("cure");
        //调用实例方法
        h.curing();
    }
}
