package ink.onei.dao;

import ink.onei.entity.User;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户数据库接口
 * @Date: 12/12/2023 11:08 Tuesday
 */

public interface IUserDao {
    Integer insert(User user);

    Integer update(User user);

    Integer delete(User user);

    Integer deleteBatch(List<Integer> idList);

    User getUserDynamic(User user);

    Integer updateUserDynamic(User user);

    List<User> getAllUsers();
}
