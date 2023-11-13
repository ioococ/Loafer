package user.service;

import user.entity.User;
import user.exception.UserException;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/10 14:41 星期五
 */

public interface IUserService {
    public int register(String username, String password) throws UserException;

    public User login(String username, String password) throws UserException;
}
