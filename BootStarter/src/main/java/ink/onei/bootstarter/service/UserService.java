package ink.onei.bootstarter.service;

import ink.onei.bootstarter.entity.User;
import ink.onei.bootstarter.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2024-01-04 09:34:07
 */
@Service("userService")
public class UserService implements IUserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userMapper.queryById(id);
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
    public User update(User user) {
        this.userMapper.update(user);
        return this.queryById(user.getId());
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
}
