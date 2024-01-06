package ink.onei.bootstarter.mapper;

import ink.onei.bootstarter.vo.ScoreDetailVO;

import java.util.List;

/**
 * (CourseSelections)表数据库访问层
 *
 * @author nekotako
 * @since 2024-01-06 15:34:09
 */
public interface CourseSelectionsDao {

    List<ScoreDetailVO> getScoreList(ScoreDetailVO scoreDetail);

}

