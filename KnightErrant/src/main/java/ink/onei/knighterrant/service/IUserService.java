package ink.onei.knighterrant.service;

import ink.onei.knighterrant.entity.User;
import ink.onei.knighterrant.vo.UserDetailVO;

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

    List<User> getUserList();

    UserDetailVO getUserDetail(Integer id);

    Integer updateUserDynamic(User user);

    Integer deleteBatch(List<Integer> idList);
}
