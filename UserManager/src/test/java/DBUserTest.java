import ink.onei.dao.IUserDao;
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
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 数据库方法测试
 * @Date: 05/12/2023 14:43 Tuesday
 */

public class DBUserTest {
    SqlSession session = null;
    IUserDao userDao;

    @Before
    public void before() throws IOException {
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @Test
    public void add() {
        User user = new User("root", "root", "男", "11111", "1@1.com", new Date(997718400), "root");
        Integer add = userDao.add(user);
    }

    @Test
    public void update() {
        User user = new User("root", "P@$$vvr0d", "男", "11111", "1@1.com", new Date(997718400), "root");
        Integer add = userDao.add(user);
    }

    @Test
    public void delete() {
        session.delete("User.deleteUserById", 106);
    }

    @Test
    public void select() {
        User user = userDao.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void selectList() {
        List<User> allUser = userDao.getAllUser();
        System.out.println(allUser.size());
    }

    @After
    public void after() {
        session.commit();
    }
}
