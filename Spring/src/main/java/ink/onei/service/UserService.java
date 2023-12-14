package ink.onei.service;

import ink.onei.dao.IUserDao;
import ink.onei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户业务类
 * @Date: 2023/11/10 14:41 星期五
 */

@Service
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    // 使用有参构造器时最好显式申明一个无参构造器
    public UserService() {
    }


    /**
     * @param user
     * @return
     */
    @Override
    public Boolean add(User user) {
        try {
            return userDao.insert(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Boolean modify(User user) {
        try {
            return userDao.update(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Boolean delete(User user) {
        try {
            return userDao.delete(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User getUserById(Integer id) {
        try {
            return userDao.getUserById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return 返回所有用户信息 类型为List<User>
     */
    @Override
    public List<User> getAllUsers() {
        List<User> users;
        try {
            users = userDao.getAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @PostConstruct
    public void init() {
//        System.out.println("初始化");
//        System.out.println(this);
//        System.out.println("UserDao对象为 " + userDao);
    }

    @PreDestroy
    public void destroy() {
//        System.out.println("销毁");
    }
}
