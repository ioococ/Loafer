package ink.onei.dao;

import ink.onei.entity.Score;
import ink.onei.entity.User;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: Score 接口
 * @Date: 05/12/2023 15:42 Tuesday
 */

public interface IScoreDao {
    Integer add(Score score);

    Integer updateScoreById(Score score);

    Integer deleteScoreById(Integer id);

    Score getScoreById(Integer id);

    List<Score> getAllScore();
}
