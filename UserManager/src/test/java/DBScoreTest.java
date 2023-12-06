import ink.onei.dao.IScoreDao;
import ink.onei.entity.Score;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 数据库方法测试
 * @Date: 05/12/2023 14:43 Tuesday
 */

public class DBScoreTest {
    SqlSession session;
    IScoreDao scoreDao;

    @Before
    public void before() throws IOException {
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        session = new SqlSessionFactoryBuilder().build(inputStream).openSession();
        scoreDao = session.getMapper(IScoreDao.class);

    }

    @Test
    public void insert() {
        Score score = new Score(1, 50);
        Integer insert = scoreDao.add(score);
    }

    @Test
    public void update() {
        Score score = new Score(51, 1, 50);
        scoreDao.updateScoreById(score);
    }

    @Test
    public void delete() {
        scoreDao.deleteScoreById(51);
    }

    @Test
    public void select() {
        Score score = scoreDao.getScoreById(1);
        System.out.println(score);
    }

    @Test
    public void selectList() {
        List<Score> allScore = scoreDao.getAllScore();
        System.out.println(allScore.size());
        for (Score score : allScore) {
            System.out.println(score);
        }
    }

    @After
    public void after() {
        session.commit();
    }
}
