package ink.onei.usermanage.service;

import ink.onei.usermanage.entity.User;
import ink.onei.usermanage.exception.UserException;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/10 14:41 星期五
 */

public interface IUserService {
    public int register(String username, String password) throws UserException;

    public int register(String username, String password, String email) throws UserException;

    public User login(String username, String password) throws UserException;
    public List<User> getAllUsers();
}
