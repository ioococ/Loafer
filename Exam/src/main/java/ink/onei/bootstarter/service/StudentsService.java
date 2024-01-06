package ink.onei.bootstarter.service;

import ink.onei.bootstarter.entity.Students;

import java.util.List;

/**
 * (Students)表服务接口
 *
 * @author nekotako
 * @since 2024-01-06 15:34:18
 */
public interface StudentsService {

    /**
     * 通过ID查询单条数据
     *
     * @param studentId 主键
     * @return 实例对象
     */
    Students queryById(Integer studentId);

    /**
     * 分页查询
     *
     * @param students 筛选条件
     * @return 查询结果
     */
    List<Students> getStudentsList(Students students);

    /**
     * 新增数据
     *
     * @param students 实例对象
     * @return 实例对象
     */
    Integer add(Students students);

    /**
     * 修改数据
     *
     * @param students 实例对象
     * @return 实例对象
     */
    Integer modify(Students students);

    /**
     * 通过主键删除数据
     *
     * @param studentId 主键
     * @return 是否成功
     */
    Integer deleteById(Integer studentId);

}
