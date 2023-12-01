package ink.onei.usermanage.service;

import ink.onei.usermanage.dao.UserDao;
import ink.onei.usermanage.entity.User;
import ink.onei.usermanage.exception.UserException;

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
     * @param username 要添加的用户名
     * @param password 要添加的密码
     * @return 返回受影响行数
     * @throws UserException <b>用户已存在</b>异常
     */

    @Override
    public int register(String username, String password) throws UserException {
        return register(username, password, null);
    }

    /**
     * 先进行校验 如果存在则抛出异常 不存在则进行添加
     *
     * @param username 要添加的用户名
     * @param password 要添加的密码
     * @param email    要添加的电子邮件
     * @return 返回受影响行数
     * @throws UserException <b>用户已存在</b>异常
     */
    @Override
    public int register(String username, String password, String email) throws UserException {
        UserDao userDao = new UserDao();
        try {
            user = userDao.queryByUsername(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (user == null) {
            user = new User(username, password, email);
            try {
                rows = userDao.add(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new UserException("用户已存在");
        }
        return rows;
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
            user = userDao.querySingleUser(username, password);
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
}
