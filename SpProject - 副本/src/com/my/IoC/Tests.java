package com.my.IoC;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tests {
    @Test
    public void testx() {
        //指定配置文件名称
        String XmlFile = "applicationContext.xml";
        //加载配置文件 初始化Spring
        ApplicationContext aC = new ClassPathXmlApplicationContext(XmlFile);
        //通过容器获得userDao实例 (向Spring请求实例)
        UserDao userDao = (UserDao) aC.getBean("userDao");
        //调用实例方法
        userDao.save();
    }

//    public void testy() {
//        UserDao userDao = new UDImp();
//        //调用实例方法
//        userDao.save();
//    }

    @Test
    public void setterTest() {
        //指定配置文件
        String XmlFile = "applicationContext.xml";
        //加载配置文件 初始化Spring
        ApplicationContext aC = new ClassPathXmlApplicationContext(XmlFile);
        //通过实例获得UserService方法
        UserService uS = (UserService) aC.getBean("userService");
        //调用实例方法
        uS.addUser();
    }

//    @Test
//    public void Test1() {
//        USImp userServiceI = new USImp();
//        UDImp userDaoI = new UDImp();
//        userServiceI.setUserDao(userDaoI);
//        userServiceI.addUser();
//    }

    @Test
    public void constructionMethodTest() {
        //指定配置文件
        String XmlFile = "applicationContext.xml";
        //加载配置文件 初始化Spring
        ApplicationContext aC = new ClassPathXmlApplicationContext(XmlFile);
        //通过实例获得UserService方法
        UserService uS = (UserService) aC.getBean("userService");
        //调用实例方法
        uS.addUser();
    }
}
