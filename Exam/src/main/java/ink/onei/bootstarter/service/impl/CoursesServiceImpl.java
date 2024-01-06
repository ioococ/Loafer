package ink.onei.bootstarter.service.impl;

import ink.onei.bootstarter.entity.Courses;
import ink.onei.bootstarter.mapper.CoursesDao;
import ink.onei.bootstarter.service.CoursesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Courses)表服务实现类
 *
 * @author nekotako
 * @since 2024-01-06 15:34:17
 */
@Service("coursesService")
public class CoursesServiceImpl implements CoursesService {
    @Resource
    private CoursesDao coursesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param courseId 主键
     * @return 实例对象
     */
    @Override
    public Courses queryById(Integer courseId) {
        return this.coursesDao.queryById(courseId);
    }

    /**
     * 分页查询
     *
     * @param courses 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Courses> queryByPage(Courses courses, PageRequest pageRequest) {
        long total = this.coursesDao.count(courses);
        return new PageImpl<>(this.coursesDao.queryAllByLimit(courses, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param courses 实例对象
     * @return 实例对象
     */
    @Override
    public Courses insert(Courses courses) {
        this.coursesDao.insert(courses);
        return courses;
    }

    /**
     * 修改数据
     *
     * @param courses 实例对象
     * @return 实例对象
     */
    @Override
    public Courses update(Courses courses) {
        this.coursesDao.update(courses);
        return this.queryById(courses.getCourseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param courseId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer courseId) {
        return this.coursesDao.deleteById(courseId) > 0;
    }
}
