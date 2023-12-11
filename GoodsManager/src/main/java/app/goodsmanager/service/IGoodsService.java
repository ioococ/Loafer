package app.goodsmanager.service;

import app.goodsmanager.entity.Good;
import app.goodsmanager.entity.User;
import app.goodsmanager.exception.UserException;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 商品业务接口
 * @Date: 2023/11/10 14:41 星期五
 */

public interface IGoodsService {
    List<Good> getAllGoods();
}
