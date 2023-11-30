package app.usermanger.dao;


import app.usermanger.entity.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);

    Integer register(User user);

    List<User> getAll();
}
