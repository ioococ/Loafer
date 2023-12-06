package com.my.constructor;

public class CBean {
    //默认无参构造器 Spring通过此构造器实例化
    public CBean() {
        System.out.println("CBean 的构造器");
    }
    public void toStr() {
        System.out.println("通过构造器实例化Bean");
    }
}
