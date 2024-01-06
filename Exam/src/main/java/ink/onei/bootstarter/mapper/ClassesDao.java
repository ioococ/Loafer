package ink.onei.bootstarter.mapper;

import ink.onei.bootstarter.entity.Classes;
import ink.onei.bootstarter.vo.ClassDetailVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Classes)表数据库访问层
 *
 * @author nekotako
 * @since 2024-01-06 15:33:56
 */
public interface ClassesDao {

    List<ClassDetailVO> getClassesList();
}

