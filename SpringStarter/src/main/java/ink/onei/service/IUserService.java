package ink.onei.service;

import ink.onei.entity.User;
import ink.onei.exception.UserException;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户业务接口
 * @Date: 2023/11/10 14:41 星期五
 */

public interface IUserService {

    Integer signup(User user) throws UserException;

    User login(String username, String password) throws UserException;

    List<User> getAllUsers();

    User getUserByName(String username);

    Integer deleteUserById(Integer id);

    User test(Integer id);
}
