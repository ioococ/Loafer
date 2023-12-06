package com.my.cglib;

public class BAspect {
    public static void before() {
        System.out.println("核对图书");
    }
    public static void after() {
        System.err.println("记录图书操作信息");
    }
}
