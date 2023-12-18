package ink.onei.service;

import ink.onei.entity.Goods;
import ink.onei.entity.Order;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户业务接口
 * @Date: 2023/11/10 14:41 星期五
 */

public interface IGoodsService {

    //    Integer add(User user);
//    Integer modify(User user);
//    Integer delete(User user);
    Goods getGoodsById(Integer id);

    List<Goods> getAllGoods();

}
