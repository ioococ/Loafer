package user;//import org.junit.Test;

import org.junit.Test;
import user.dao.UserDao;
import user.entity.User;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/10 15:44 星期五
 */

public class DaoTest {
    @Test
    public void queryTest() throws SQLException {
        UserDao userDao = new UserDao();
        User user = userDao.queryByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void insertTest() throws SQLException {
        UserDao userDao = new UserDao();
        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户：");
        String username = input.nextLine();
        System.out.print("请输入密码：");
        String password = input.nextLine();
        User user = new User(username, password);
        int row = userDao.add(user);
        System.out.println(row);
    }
}
