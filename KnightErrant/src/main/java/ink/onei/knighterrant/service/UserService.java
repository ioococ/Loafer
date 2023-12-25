package ink.onei.knighterrant.service;

import ink.onei.knighterrant.dao.IUserDao;
import ink.onei.knighterrant.entity.User;
import ink.onei.knighterrant.vo.UserDetailVO;
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
     * 用户添加方法
     *
     * @param user 完整用户对象
     * @return 受影响行数
     */
    @Override
    public Integer add(User user) {
        return userDao.insert(user);
    }

    /**
     * 用户修改方法
     *
     * @param user 完整用户对象
     * @return 受影响行数
     */
    @Override
    public Integer modify(User user) {
        return userDao.update(user);
    }

    /**
     * 用户删除方法
     *
     * @param user 对象存在id属性即可
     * @return 受影响行数
     */
    @Override
    public Integer delete(User user) {
        return userDao.delete(user);
    }

    /**
     * 登录方法
     *
     * @param user 需要传入用户名和密码
     * @return 用户完整信息
     */
    @Override
    public User login(User user) {
        return userDao.getUserDynamic(user);
    }

    /**
     * 获取用户信息
     *
     * @param user 对象属性有其一即可
     * @return 用户完整信息
     */
    @Override
    public User getUserDynamic(User user) {
        return userDao.getUserDynamic(user);
    }

    /**
     * @return 用户列表
     */
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    /**
     * 根据用户id 获取 用户-地址信息
     *
     * @return 用户-地址视图 一对多对象
     */
    public UserDetailVO getUserDetail(Integer id) {
        return userDao.getUserDetail(id);
    }


    public Integer updateUserDynamic(User user) {
        if (user == null) {
            return 0;
        }
        return userDao.updateUserDynamic(user);
    }

    /**
     * 批量删除用户
     *
     * @param idList id列表
     * @return 受影响行数
     */
    public Integer deleteBatch(List<Integer> idList) {
        return userDao.deleteBatch(idList);
    }

}
