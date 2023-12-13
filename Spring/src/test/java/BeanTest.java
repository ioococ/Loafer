import ink.onei.entity.User;
import ink.onei.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 测试
 * @Date: 11/12/2023 19:44 Monday
 */

public class BeanTest {

    @Test
    public void bean() {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beans = applicationContext.getBeanDefinitionNames();
        UserService userService = applicationContext.getBean("userService", UserService.class);
        List<User> allUsers = userService.getAllUsers();
        System.out.println();
        System.out.println(allUsers);
    }
}
