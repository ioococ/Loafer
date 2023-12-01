package app.usermanger.service.impl;


import app.usermanger.dao.UserDao;
import app.usermanger.dao.impl.UserDaoImpl;
import app.usermanger.entity.User;
import app.usermanger.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao ud = new UserDaoImpl();

    @Override
    public User getUserByName(String name) {
        return ud.getUserByName(name);
    }

    @Override
    public Boolean register(User user) {
        return ud.register(user) >= 1 ? true : false;
    }

    @Override
    public List<User> getAll() {
        return ud.getAll();
    }
}
