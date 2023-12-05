package com.my.proxy;

public class UDImp implements UserDao{
    @Override
    public void find() {
        System.out.println("添加成功");
    }

    @Override
    public void save() {
        System.out.println("保存成功");
    }

    @Override
    public void update() {
        System.out.println("更新成功");
    }

    @Override
    public void delete() {
        System.out.println("删除成功");
    }
}
