package ink.onei.service;

import ink.onei.entity.User;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户业务接口
 * @Date: 2023/11/10 14:41 星期五
 */

public interface IUserService {

    List<User> getAllUsers();
}
