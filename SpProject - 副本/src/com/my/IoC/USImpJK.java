package com.my.IoC;

public class USImpJK implements UserService{
    //使用UserDao声明对象
    private UserDao userDao;
    //添加构造方法 注入userDao
    public USImpJK(UserDao userDao) {
        this.userDao = userDao;
    }

    public USImpJK(UDImp udImp) {
    }

    @Override
    public void addUser() {
        this.userDao.save();
        System.out.println("使用构造方法 通过Spring依赖注入的方式 执行UserDao中方法");
    }
}
