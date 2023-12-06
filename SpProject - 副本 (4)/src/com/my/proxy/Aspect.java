package com.my.proxy;

public class Aspect {
    public void before() {
        System.err.println("方法执行前 对用户进行检查");
    }

    public void after() {
        System.out.println("方法执行后 添加用户日志");
    }
}
