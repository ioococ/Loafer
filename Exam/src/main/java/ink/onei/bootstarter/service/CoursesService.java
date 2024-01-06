package ink.onei.bootstarter.service;

import ink.onei.bootstarter.entity.Courses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Courses)表服务接口
 *
 * @author nekotako
 * @since 2024-01-06 15:34:17
 */
public interface CoursesService {

    /**
     * 通过ID查询单条数据
     *
     * @param courseId 主键
     * @return 实例对象
     */
    Courses queryById(Integer courseId);

    /**
     * 分页查询
     *
     * @param courses 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Courses> queryByPage(Courses courses, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param courses 实例对象
     * @return 实例对象
     */
    Courses insert(Courses courses);

    /**
     * 修改数据
     *
     * @param courses 实例对象
     * @return 实例对象
     */
    Courses update(Courses courses);

    /**
     * 通过主键删除数据
     *
     * @param courseId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer courseId);

}
