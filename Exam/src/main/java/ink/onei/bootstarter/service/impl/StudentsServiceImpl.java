package ink.onei.bootstarter.service.impl;

import ink.onei.bootstarter.entity.Students;
import ink.onei.bootstarter.mapper.StudentsDao;
import ink.onei.bootstarter.service.StudentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Students)表服务实现类
 *
 * @author nekotako
 * @since 2024-01-06 15:34:18
 */
@Service("studentsService")
public class StudentsServiceImpl implements StudentsService {
    @Resource
    private StudentsDao studentsDao;

    @Override
    public Students queryById(Integer studentId) {
        return this.studentsDao.queryById(studentId);
    }

    @Override
    public List<Students> getStudentsList(Students students) {
        return studentsDao.getStudentsList(students);
    }

    @Override
    public Integer add(Students students) {
        return studentsDao.insert(students);
    }

    @Override
    public Integer modify(Students students) {
        return studentsDao.update(students);
    }

    @Override
    public Integer deleteById(Integer studentId) {
        return this.studentsDao.deleteById(studentId);
    }
}
