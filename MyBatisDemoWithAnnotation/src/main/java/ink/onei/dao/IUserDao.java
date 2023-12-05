package ink.onei.dao;

import ink.onei.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: User 接口
 * @Date: 05/12/2023 15:42 Tuesday
 */


public interface IUserDao {
    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);

    @Select("select * from user")
    List<User> getAllUser();
}
