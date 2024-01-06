package ink.onei.bootstarter.mapper;

import ink.onei.bootstarter.entity.Students;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Students)表数据库访问层
 *
 * @author nekotako
 * @since 2024-01-06 15:34:17
 */
public interface StudentsDao {

    Students queryById(Integer studentId);

    List<Students> getStudentsList(Students students);

    int insert(Students students);

    int insertBatch(@Param("entities") List<Students> entities);

    int update(Students students);

    int deleteById(Integer studentId);

}

