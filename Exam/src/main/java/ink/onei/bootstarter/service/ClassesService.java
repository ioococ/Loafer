package ink.onei.bootstarter.service;

import ink.onei.bootstarter.entity.Classes;
import ink.onei.bootstarter.vo.ClassDetailVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Classes)表服务接口
 *
 * @author nekotako
 * @since 2024-01-06 15:34:08
 */
public interface ClassesService {

    List<ClassDetailVO> getClassesList();
}
