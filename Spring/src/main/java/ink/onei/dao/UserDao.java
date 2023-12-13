package ink.onei.dao;

import ink.onei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户表操作
 * @Date: 2023/11/10 14:40 星期五
 */

@Configurable
@Repository("userDao")
public class UserDao implements IUserDao {

    @Autowired
    User user = null;
    /**
     * @return 返回所有用户信息 类型为List<User>
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < 3; i++) {
            user.setId(count++);
            user.setUsername("onei");
        }
        users.add(user);
        return users;
    }
}
