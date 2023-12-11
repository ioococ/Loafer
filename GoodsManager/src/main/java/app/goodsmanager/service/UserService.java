package app.goodsmanager.service;

import app.goodsmanager.dao.UserDao;
import app.goodsmanager.entity.User;
import app.goodsmanager.exception.UserException;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户业务类
 * @Date: 2023/11/10 14:41 星期五
 */

public class UserService implements IUserService {
    int rows = 0;

    User user = null;


    /**
     * 先进行校验 如果存在则抛出异常 不存在则进行添加
     *
     * @param user 要添加的用户
     * @return 返回受影响行数
     * @throws UserException <b>用户已存在</b>异常
     */
    @Override
    public int signup(User user) throws UserException {
        UserDao userDao = new UserDao();
        User tempUser = null;
        try {
            tempUser = userDao.getUserByName(user.getUsername());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (tempUser != null) {
            throw new UserException("用户已存在");
        } else {
            // 如果用户不存在则进行添加
            try {
                rows = userDao.add(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return rows;

        }
    }

    /**
     * @param username 用户名
     * @param password 密码
     * @return 返回受影响行数
     * @throws UserException <b>用户名或密码错误</b>异常
     */
    @Override
    public User login(String username, String password) throws UserException {
        UserDao userDao = new UserDao();
        try {
            user = userDao.getSingleUser(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (user == null) {
            throw new UserException("用户名或密码错误");
        }
        return user;
    }

    /**
     * @return 返回所有用户信息 类型为List<User>
     */
    @Override
    public List<User> getAllUsers() {
        UserDao userDao = new UserDao();
        List<User> users;
        try {
            users = userDao.queryAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    /**
     * @param username 根据用户名查询密码
     * @return 用户存在返回当前用户 用户不存在返回null
     */
    @Override
    public User getUserByName(String username) {
        UserDao userDao = new UserDao();
        try {
            return userDao.getUserByName(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteUserById(int id) {
        UserDao userDao = new UserDao();
        try {
            return userDao.deleteUserById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
