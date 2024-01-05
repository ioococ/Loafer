package ink.onei.bootstarter.service;

import ink.onei.bootstarter.etc.OperaException;
import ink.onei.bootstarter.entity.User;
import ink.onei.bootstarter.mapper.IUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author nekotako
 * @since 2024-01-04 09:34:07
 */
@Service("userService")
public class UserService implements IUserService {
    @Resource
    private IUserMapper userMapper;

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userMapper.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(User user) {
        return this.userMapper.update(user);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userMapper.deleteById(id) > 0;
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    @Override
    public List<User> getUserList(User user) {
        return userMapper.getUserList(user);
    }

    @Override
    public Boolean login(User user) {
// @formatter:off
        User u = new User();u.setUsername(user.getUsername());
        if (userMapper.getUser(u) == null) throw new OperaException("用户不存在");
        else{
            if (userMapper.getUser(user) == null) throw new OperaException("账号或密码错误");
            else return true;
        }
// @formatter:on
    }
}
