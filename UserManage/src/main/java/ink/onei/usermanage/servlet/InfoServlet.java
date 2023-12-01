package ink.onei.usermanage.servlet;

import ink.onei.usermanage.entity.User;
import ink.onei.usermanage.service.UserService;
import ink.onei.usermanage.utils.EncodingUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

//返回所有用户信息
@WebServlet(value = "/info", loadOnStartup = 1)
public class InfoServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 8019621082112763650L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserService userService = new UserService();
        EncodingUtils.setCharacterEncoding(req, resp);
        StringBuilder sb = new StringBuilder();
        List<User> users = userService.getAllUsers();
        int count = 0;
        for (User user : users) {
            count++;
            sb.append("[").append("\"").append(user.getUsername()).append("\",");
            sb.append("\"").append(user.getSex()).append("\",");
            sb.append("\"").append(user.getEmail()).append("\",");
            sb.append("\"").append(user.getPhone()).append("\",");
            sb.append("\"").append(user.getBirthday()).append("\",");
            sb.append("\"").append(user.getNickname()).append("\",");
            if (user.equals(users.get(users.size() - 1))) {
                sb.append("\"").append(user.getCreatedate()).append("\"").append("]");
            } else {
                sb.append("\"").append(user.getCreatedate()).append("\"").append("],");
            }
        }
        resp.getWriter().print("{\"count\": \"" + count + "\",\"sumPages\": \"10\",\"arraysLength\": \"5\",\"Arrays\": [" + sb + "]}");
//        resp.getWriter().println("{\"count\": \"" + count + "\",\"sumPages\": \"10\",\"arraysLength\": \"5\",\"Arrays\": [[\"username\",\"sex\",\"phone\",\"email\",\"birthday\",\"nickname\",\"createdate\"],[\"username\",\"sex\",\"phone\",\"email\",\"birthday\",\"nickname\",\"createdate\"],[\"username\",\"sex\",\"phone\",\"email\",\"birthday\",\"nickname\",\"createdate\"],[\"username\",\"sex\",\"phone\",\"email\",\"birthday\",\"nickname\",\"createdate\"],[\"username\",\"sex\",\"phone\",\"email\",\"birthday\",\"nickname\",\"createdate\"]]}");

    }
}
