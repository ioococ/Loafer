package com.my.example;

public class EFBean {
    public EFBean() {
        System.out.println("实例工厂创建成功");
    }
    public EBean createBean() {
        return new EBean();
    }
}
