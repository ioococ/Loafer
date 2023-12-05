package com.my.IoC;

public class UDImp2 implements UserDao{

    @Override
    public void save() {
        System.out.println("实现了UserDao的save()方法");
    }

}
