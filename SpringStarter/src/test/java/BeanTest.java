import ink.onei.mapper.UserDao;
import ink.onei.entity.User;
import ink.onei.service.UserService;
import lombok.Setter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: nekotako
 * @Description: 测试
 * @Date: 11/12/2023 19:44 Monday
 */

public class BeanTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContent.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        Class<UserService> userServiceClass = UserService.class;
        UserService userService1 = userServiceClass.newInstance();

        System.out.println(1);
        User test = userService.test(1);
        System.out.println(userService);
        System.out.println(test);

    }
    @Test
    public void bean() throws InstantiationException, IllegalAccessException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        Class<UserService> userServiceClass = UserService.class;
        User test = userDao.test(1);
//        User test = userService.test(1);
//        System.out.println(userService);
        System.out.println(test);
    }
}
