package ink.onei.service;

import ink.onei.dao.IUserDao;
import ink.onei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * @param user
     * @return
     */
    @Override
    public Integer add(User user) {
        return userDao.insert(user);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Integer modify(User user) {
        return userDao.update(user);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Integer delete(User user) {
        return userDao.delete(user);
    }

    public User login(User user) {
        return userDao.getUserDynamic(user);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public User getUserDynamic(User user) {
        return userDao.getUserDynamic(user);
    }

    /**
     * @return 返回所有用户信息 类型为List<User>
     */
    @Override
    public List<User> getAllUsers() {
        List<User> users;
        users = userDao.getAllUsers();
        return users;
    }

    /**
     * @param idList
     * @return
     */
    public Integer deleteBatch(List<Integer> idList) {
        return userDao.deleteBatch(idList);
    }

}
