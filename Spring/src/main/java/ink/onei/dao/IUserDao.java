package ink.onei.dao;

import ink.onei.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户数据库接口
 * @Date: 12/12/2023 11:08 Tuesday
 */

public interface IUserDao {
    Boolean insert(User user) throws SQLException;

    Boolean update(User user) throws SQLException;

    Boolean delete(User user) throws SQLException;

    User getSingleUser(String username, String password) throws SQLException;

    User getUserById(Integer id) throws SQLException;

    User getUserByName(String username) throws SQLException;

    List<User> getAllUsers() throws SQLException;
}
