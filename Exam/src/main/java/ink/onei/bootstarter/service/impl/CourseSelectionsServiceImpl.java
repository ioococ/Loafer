package ink.onei.bootstarter.service.impl;

import ink.onei.bootstarter.entity.CourseSelections;
import ink.onei.bootstarter.mapper.CourseSelectionsDao;
import ink.onei.bootstarter.service.CourseSelectionsService;
import ink.onei.bootstarter.vo.ScoreDetailVO;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CourseSelections)表服务实现类
 *
 * @author nekotako
 * @since 2024-01-06 15:34:15
 */
@Service("courseSelectionsService")
public class CourseSelectionsServiceImpl implements CourseSelectionsService {
    @Resource
    private CourseSelectionsDao courseSelectionsDao;

    @Override
    public List<ScoreDetailVO> getScoreList(ScoreDetailVO scoreDetail) {
        return courseSelectionsDao.getScoreList(scoreDetail);
    }
}
