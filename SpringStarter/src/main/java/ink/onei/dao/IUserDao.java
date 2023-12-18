package ink.onei.mapper;

import ink.onei.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户数据库接口
 * @Date: 12/12/2023 11:08 Tuesday
 */

public interface IUserDao {
    Integer insert(User user) throws SQLException;

    User getSingleUser(String username, String password) throws SQLException;

    User getUserByName(String username) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    Integer deleteUserById(int id) throws SQLException;

    User test(Integer id);
}
