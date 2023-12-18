package ink.onei.mapper;

import ink.onei.dto.OrderDetailDTO;
import ink.onei.dto.UserDetailDTO;
import ink.onei.entity.User;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户数据库接口
 * @Date: 12/12/2023 11:08 Tuesday
 */

public interface IUserMapper {

    User getUserById(Integer id);

    User getUserByName(String username);

    UserDetailDTO getDetailByUserId(Integer userId);

    List<User> getAllUsers();


}
