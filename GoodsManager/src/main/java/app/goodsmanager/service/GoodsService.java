package app.goodsmanager.service;

import app.goodsmanager.dao.GoodsDao;
import app.goodsmanager.entity.Good;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户业务类
 * @Date: 2023/11/10 14:41 星期五
 */

public class GoodsService implements IGoodsService {
    GoodsDao goodsDao = new GoodsDao();

    @Override
    public List<Good> getAllGoods() {
        try {
            return goodsDao.queryAllGoods();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
