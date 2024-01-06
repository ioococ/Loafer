package ink.onei.bootstarter.service;

import ink.onei.bootstarter.entity.Teachers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Teachers)表服务接口
 *
 * @author nekotako
 * @since 2024-01-06 15:34:21
 */
public interface TeachersService {

    /**
     * 通过ID查询单条数据
     *
     * @param teacherId 主键
     * @return 实例对象
     */
    Teachers queryById(Integer teacherId);

    /**
     * 分页查询
     *
     * @param teachers 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Teachers> queryByPage(Teachers teachers, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param teachers 实例对象
     * @return 实例对象
     */
    Teachers insert(Teachers teachers);

    /**
     * 修改数据
     *
     * @param teachers 实例对象
     * @return 实例对象
     */
    Teachers update(Teachers teachers);

    /**
     * 通过主键删除数据
     *
     * @param teacherId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer teacherId);

}
