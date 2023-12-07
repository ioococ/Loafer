package ink.onei.dao;

import ink.onei.dto.PageInfos;
import ink.onei.entity.User;
import ink.onei.vo.UserAndAddressVO;

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

    List<User> getUserDynamic(User user);

    User getUserById(Integer id);

    List<User> getAllUser();

    /**
     * @param id 用户id
     * @return 用户-地址一对多对象
     */
    UserAndAddressVO userAndAddress(Integer id);

    UserAndAddressVO userAndAddressTwo(Integer id);


    List<User> getUserPage(PageInfos pageInfos);

    int getUserCount();
}
