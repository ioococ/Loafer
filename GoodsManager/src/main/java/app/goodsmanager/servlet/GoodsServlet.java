package app.goodsmanager.servlet;


import app.goodsmanager.service.GoodsService;
import app.goodsmanager.service.IGoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goods")
public class GoodsServlet extends HttpServlet {
    IGoodsService goodsService = new GoodsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getSession().getAttribute("user"));
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }

        req.getSession().setAttribute("goods", goodsService.getAllGoods());
        req.getRequestDispatcher("goods.jsp").forward(req, resp);
    }
}
