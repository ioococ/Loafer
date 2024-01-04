package ink.onei.bootstarter.service;

import ink.onei.bootstarter.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-01-04 09:34:05
 */
public interface IUserService {

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    List<User> getUserList(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    Integer update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
