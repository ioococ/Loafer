package ink.onei.bootstarter.mapper;

import ink.onei.bootstarter.entity.Courses;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Courses)表数据库访问层
 *
 * @author nekotako
 * @since 2024-01-06 15:34:16
 */
public interface CoursesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param courseId 主键
     * @return 实例对象
     */
    Courses queryById(Integer courseId);

    /**
     * 查询指定行数据
     *
     * @param courses 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Courses> queryAllByLimit(Courses courses, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param courses 查询条件
     * @return 总行数
     */
    long count(Courses courses);

    /**
     * 新增数据
     *
     * @param courses 实例对象
     * @return 影响行数
     */
    int insert(Courses courses);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Courses> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Courses> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Courses> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Courses> entities);

    /**
     * 修改数据
     *
     * @param courses 实例对象
     * @return 影响行数
     */
    int update(Courses courses);

    /**
     * 通过主键删除数据
     *
     * @param courseId 主键
     * @return 影响行数
     */
    int deleteById(Integer courseId);

}

