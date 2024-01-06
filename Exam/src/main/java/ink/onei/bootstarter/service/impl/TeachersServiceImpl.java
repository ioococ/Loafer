package ink.onei.bootstarter.service.impl;

import ink.onei.bootstarter.entity.Teachers;
import ink.onei.bootstarter.mapper.TeachersDao;
import ink.onei.bootstarter.service.TeachersService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Teachers)表服务实现类
 *
 * @author nekotako
 * @since 2024-01-06 15:34:21
 */
@Service("teachersService")
public class TeachersServiceImpl implements TeachersService {
    @Resource
    private TeachersDao teachersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param teacherId 主键
     * @return 实例对象
     */
    @Override
    public Teachers queryById(Integer teacherId) {
        return this.teachersDao.queryById(teacherId);
    }

    /**
     * 分页查询
     *
     * @param teachers 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Teachers> queryByPage(Teachers teachers, PageRequest pageRequest) {
        long total = this.teachersDao.count(teachers);
        return new PageImpl<>(this.teachersDao.queryAllByLimit(teachers, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param teachers 实例对象
     * @return 实例对象
     */
    @Override
    public Teachers insert(Teachers teachers) {
        this.teachersDao.insert(teachers);
        return teachers;
    }

    /**
     * 修改数据
     *
     * @param teachers 实例对象
     * @return 实例对象
     */
    @Override
    public Teachers update(Teachers teachers) {
        this.teachersDao.update(teachers);
        return this.queryById(teachers.getTeacherId());
    }

    /**
     * 通过主键删除数据
     *
     * @param teacherId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer teacherId) {
        return this.teachersDao.deleteById(teacherId) > 0;
    }
}
