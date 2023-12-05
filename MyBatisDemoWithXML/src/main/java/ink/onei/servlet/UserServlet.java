package ink.onei.servlet;

import ink.onei.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

/**
 * @Author: nekotako
 * @Description: 添加方法
 * @Date: 05/12/2023 10:58 Tuesday
 */
@WebServlet("/add")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = factory.openSession()) {
            User user = new User("root", "root", "男", "11111", "1@1.com", new Date(997718400), "root");
            session.insert("User.add", user);
            session.commit();
        }
    }
}
