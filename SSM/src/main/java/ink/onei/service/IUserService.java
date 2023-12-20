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

    Integer add(User user);

    Integer modify(User user);

    Integer delete(User user);

    User login(User user);

    User getUserDynamic(User user);

    List<User> getAllUsers();

    Integer deleteBatch(List<Integer> idList);
}
