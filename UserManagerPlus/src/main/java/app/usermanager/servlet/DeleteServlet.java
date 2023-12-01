package app.usermanager.servlet;

import app.usermanager.service.IUserService;
import app.usermanager.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 2193320400498892924L;
    IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    /**
     * 获取前端传来的id进行删除用户
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        IUserService userService = new UserService();
        int rows = userService.deleteUserById(id);
        if (rows != 0) {
            resp.getWriter().print("{\"msg\": \"ok\"\n}");
        }
    }
}
