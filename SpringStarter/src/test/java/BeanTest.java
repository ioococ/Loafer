import ink.onei.entity.User;
import ink.onei.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: nekotako
 * @Description: 测试
 * @Date: 11/12/2023 19:44 Monday
 */

public class BeanTest {
    @Test
    public void bean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContent.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        User test = userService.test(1);
        System.out.println(test);
    }
}
