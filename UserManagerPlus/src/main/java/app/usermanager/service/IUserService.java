package app.usermanager.service;

import app.usermanager.entity.User;
import app.usermanager.exception.UserException;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户业务接口
 * @Date: 2023/11/10 14:41 星期五
 */

public interface IUserService {

    public int signup(User user) throws UserException;

    public User login(String username, String password) throws UserException;

    public List<User> getAllUsers();

    User getUserByName(String username);

    int deleteUserById(int id);
}
