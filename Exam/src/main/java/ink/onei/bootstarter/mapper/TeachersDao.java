package ink.onei.bootstarter.mapper;

import ink.onei.bootstarter.entity.Teachers;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Teachers)表数据库访问层
 *
 * @author nekotako
 * @since 2024-01-06 15:34:18
 */
public interface TeachersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param teacherId 主键
     * @return 实例对象
     */
    Teachers queryById(Integer teacherId);

    /**
     * 查询指定行数据
     *
     * @param teachers 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Teachers> queryAllByLimit(Teachers teachers, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param teachers 查询条件
     * @return 总行数
     */
    long count(Teachers teachers);

    /**
     * 新增数据
     *
     * @param teachers 实例对象
     * @return 影响行数
     */
    int insert(Teachers teachers);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Teachers> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Teachers> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Teachers> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Teachers> entities);

    /**
     * 修改数据
     *
     * @param teachers 实例对象
     * @return 影响行数
     */
    int update(Teachers teachers);

    /**
     * 通过主键删除数据
     *
     * @param teacherId 主键
     * @return 影响行数
     */
    int deleteById(Integer teacherId);

}

