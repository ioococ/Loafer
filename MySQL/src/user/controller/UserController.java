package user.controller;

import user.entity.User;
import user.exception.UserException;
import user.service.UserService;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/10 14:41 星期五
 */

public class UserController {
    UserService userService = new UserService();

    public void login(String username, String password) {
        try {
            User user = userService.login(username, password);
            System.out.println(user);
        } catch (UserException e) {
            // 错误信息返回给前端
            throw new RuntimeException(e);
        }
    }

    public void register(String username, String password, String sex,
                         String phone, String email, java.sql.Date birth,String nickname) {
        try {
            int rows = userService.register(username, password);
            System.out.println(rows);
        } catch (UserException e) {
            // 错误信息返回给前端
            throw new RuntimeException(e);
        }
    }
}
