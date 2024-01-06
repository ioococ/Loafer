package ink.onei.bootstarter.service.impl;

import ink.onei.bootstarter.entity.Classes;
import ink.onei.bootstarter.mapper.ClassesDao;
import ink.onei.bootstarter.service.ClassesService;
import ink.onei.bootstarter.vo.ClassDetailVO;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Classes)表服务实现类
 *
 * @author nekotako
 * @since 2024-01-06 15:34:08
 */
@Service("classesService")
public class ClassesServiceImpl implements ClassesService {
    @Resource
    private ClassesDao classesDao;

    public List<ClassDetailVO> getClassesList(){
        return classesDao.getClassesList();
    }

}
