package user;

import org.junit.Test;
import user.entity.User;
import user.exception.UserException;
import user.service.UserService;

/**
 * @Author: nekotako
 * @Description: 用户业务测试
 * @Date: 2023/11/10 19:13 星期五
 */

public class ServiceTest {

    @Test
    public void loginTest() {
        UserService userService = new UserService();
        try {
            User user = userService.login("admin", "admin");
            System.out.println(user);
        } catch (UserException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void registerTest() {
        UserService userService = new UserService();
        try {
            int rows = userService.register("admin2", "admin");
            System.out.println(rows);
        } catch (UserException e) {
            throw new RuntimeException(e);
        }
    }
}
