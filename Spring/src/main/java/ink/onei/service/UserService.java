package ink.onei.service;

import ink.onei.dao.IUserDao;
import ink.onei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户业务类
 * @Date: 2023/11/10 14:41 星期五
 */
@Service("userService")
public class UserService implements IUserService {

    @Resource
    IUserDao userDao = null;

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
     * @return 返回所有用户信息 类型为List<User>
     */
    @Override
    public List<User> getAllUsers() {
        List<User> users;

        users = userDao.getAllUsers();

        return users;
    }


    public void init() {
//        System.out.println("初始化");
//        System.out.println(this);
//        System.out.println("UserDao对象为 " + userDao);
    }

    public void destroy() {
//        System.out.println("销毁");
    }
}
