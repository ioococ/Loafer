package com.my.factory;

public class StaticBean {
    public static FBean createBean() {
        return new FBean();
    }
}
