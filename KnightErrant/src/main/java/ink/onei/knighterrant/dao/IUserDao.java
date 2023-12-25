package ink.onei.knighterrant.dao;

import ink.onei.knighterrant.entity.User;
import ink.onei.knighterrant.vo.UserDetailVO;

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
    List<User> getUserList();

    UserDetailVO getUserDetail(Integer id);

    Integer updateUserDynamic(User user);

    List<User> getAllUsers();
}
