package com.my.IoC;

public class USImp implements UserService{
    private UserDao userDao;
    //添加Setter方法 注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        this.userDao.save();
        System.out.println("通过Spring依赖注入的方式 执行了UserDao中的方法");
    }
}
