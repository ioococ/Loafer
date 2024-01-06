package ink.onei.bootstarter.service;

import ink.onei.bootstarter.entity.CourseSelections;
import ink.onei.bootstarter.vo.ScoreDetailVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (CourseSelections)表服务接口
 *
 * @author nekotako
 * @since 2024-01-06 15:34:15
 */
public interface CourseSelectionsService {

    List<ScoreDetailVO> getScoreList(ScoreDetailVO scoreDetail);


}
