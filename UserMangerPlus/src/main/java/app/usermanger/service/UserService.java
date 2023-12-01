package app.usermanger.service;


import app.usermanger.entity.User;

import java.util.List;

public interface UserService {
    User getUserByName(String name);

    Boolean register(User user);

    List<User> getAll();
}
