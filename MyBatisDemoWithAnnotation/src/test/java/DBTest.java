import ink.onei.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

/**
 * @Author: nekotako
 * @Description: 数据库方法测试
 * @Date: 05/12/2023 14:43 Tuesday
 */

public class DBTest {
    SqlSession session = null;

    @Before
    public void before() throws IOException {
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
    }

    @Test
    public void insert() {
        User user = new User("root", "root", "男", "11111", "1@1.com", new Date(997718400), "root");
        session.insert("User.add", user);
    }

    @Test
    public void delete() {
        User user = new User("root", "root", "男", "11111", "1@1.com", new Date(997718400), "root");
        session.delete("User.deleteUserById", 101);
    }

    @After
    public void after() {
        session.commit();
    }
}
