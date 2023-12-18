import ink.onei.AppConfig;
import ink.onei.mapper.IUserDao;
import ink.onei.mapper.UserDao;
import ink.onei.entity.User;
import ink.onei.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 数据库方法测试
 * @Date: 13/12/2023 18:45 Wednesday
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:**/applicationContext.xml"})
public class DBTest {

    //    @Autowired
    Connection connection = null;

    //    @Autowired
    User user = null;
    IUserDao userDao = null;

    //    @Autowired
    IUserService userService = null;
    ApplicationContext applicationContext = null;

    @Before
    public void before() {
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        user = applicationContext.getBean("user", User.class);
        userService = applicationContext.getBean("userService", IUserService.class);
        connection = applicationContext.getBean("getConnection", Connection.class);
        userDao = applicationContext.getBean("userDao", IUserDao.class);
    }

    @Test
    public void getConnection() {
        System.out.println(connection);
    }

    @Test
    public void add() {
        user.setUsername("test");
        userService.add(user);
    }

    @Test
    public void modify() {
        user.setId(51);
        user.setUsername("onei");
        user.setEmail("onei@onei.onei");
        Boolean modify = userService.modify(user);
        System.out.println(modify);
    }

    @Test
    public void delete() {
        user.setId(52);
        userService.delete(user);
    }

    @Test
    public void getSingleUser() {
        try {
            user = userDao.getSingleUser("admin", "%");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(user);
    }

    @Test
    public void getUserById() {
        try {
            user = userDao.getUserById(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(user);
    }

    @Test
    public void getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }
    }
}
