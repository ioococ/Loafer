import ink.onei.mapper.IUserDao;
import ink.onei.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * @Author: nekotako
 * @Description: 测试
 * @Date: 11/12/2023 19:44 Monday
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {
    //    @Autowired
    Connection connection = null;

    @Autowired
//    User user = null;
    IUserDao userDao = null;

    //    @Autowired
    IUserService userService = null;
    ApplicationContext applicationContext = null;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        user = applicationContext.getBean("user", User.class);
        userService = applicationContext.getBean("userService", IUserService.class);
    }

    @Test
    public void test(){
        System.out.println(userDao);
    }

    @Test
    public void beans() {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.print(name + "  ");
        }
    }

    @Test
    public void deleteBatch() {
        ArrayList<Integer> idList = new ArrayList<>();
// @formatter:off
        idList.add(51); idList.add(52); idList.add(53);
// @formatter:on
        userService.deleteBatch(idList);
    }
}
