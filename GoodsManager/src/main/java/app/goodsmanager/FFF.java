package app.goodsmanager;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 11/12/2023 10:48 Monday
 */

public class FFF extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.getAttribute("s");
    }
}
