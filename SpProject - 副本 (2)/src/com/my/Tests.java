package com.my;

import com.my.constructor.CBean;
import com.my.example.EBean;
import com.my.factory.FBean;
import com.my.user.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tests {
    @Test
    //构造器实例化Bean
    public void testw() {
        //指定配置文件
        String xmlFile = "applicationContext.xml";
        //加载配置文件 初始化Spring容器
        ApplicationContext aC = new ClassPathXmlApplicationContext(xmlFile);
        CBean cBean = (CBean) aC.getBean("cBean");
        cBean.toStr();
        System.out.println(aC.getBean("cBean"));
        System.out.println(aC.getBean("cBean"));
        System.out.println(aC.getBean("cBean"));
        System.out.println(aC.getBean("cBean"));
    }

    @Test
    //静态工厂
    public void testx() {
        //指定配置文件
        String xmlFile = "applicationContext.xml";
        //加载配置文件 初始化Spring容器
        ApplicationContext aC = new ClassPathXmlApplicationContext(xmlFile);
        FBean fBean = (FBean) aC.getBean("fBean");
        fBean.toStr();
    }

    @Test
    //实例工厂
    public void testy() {
        //指定配置文件
        String xmlFile = "applicationContext.xml";
        //加载配置文件 初始化Spring容器
        ApplicationContext aC = new ClassPathXmlApplicationContext(xmlFile);
        EBean eBean = (EBean) aC.getBean("eBean");
        eBean.toStr();
    }

    @Test
    public void testz() {
        //指定配置文件
        String xmlFile = "applicationContext.xml";
        //加载配置文件 初始化Spring容器
        ApplicationContext aC = new ClassPathXmlApplicationContext(xmlFile);
//        User user = (User) aC.getBean("cuser");
        System.out.println(aC.getBean("cuser"));
        System.out.println(aC.getBean("suser"));
    }
}
