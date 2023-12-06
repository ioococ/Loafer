package ink.onei.dao;

import ink.onei.entity.User;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: User 接口
 * @Date: 05/12/2023 15:42 Tuesday
 */

public interface IUserDao {
    Integer insert(User user);
    Integer insertBatch(List<User> userList);

    Integer updateUserById(User user);

    Integer updateUserDynamic(User user);

    Integer deleteUserById(Integer id);

    User getUserDynamic(User user);

    User getUserById(Integer id);

    List<User> getAllUser();
}
