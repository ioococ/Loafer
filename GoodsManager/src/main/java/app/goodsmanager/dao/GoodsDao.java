package app.goodsmanager.dao;

import app.goodsmanager.entity.Good;
import app.goodsmanager.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 商品表操作
 * @Date: 08/12/2023 15:07 Friday
 */

public class GoodsDao {

    Good good = null;
    Connection conn = null;

    public List<Good> queryAllGoods() throws SQLException {
        conn = DBUtils.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from goods");
        List<Good> goods = new ArrayList<>();
        while (resultSet.next()) {
            good = new Good(resultSet.getInt("id"),
                    resultSet.getString("good_name"),
                    resultSet.getInt("price")
            );
            goods.add(good);
        }
        DBUtils.close(resultSet, stmt, conn);
        return goods;
    }
}
