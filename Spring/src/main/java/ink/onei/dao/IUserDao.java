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

    List<User> getAllUsers();
}
