package ink.onei.service;

import ink.onei.dto.OrderDetailDTO;
import ink.onei.entity.Order;
import ink.onei.entity.OrderGoods;
import ink.onei.entity.User;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户业务接口
 * @Date: 2023/11/10 14:41 星期五
 */

public interface IOrderAndGoodsService {

//    Integer add(User user);
//    Integer modify(User user);
//    Integer delete(User user);

    OrderGoods getInfoById(Integer id);

    OrderGoods getInfoByOrderId(Integer orderId);

    List<OrderDetailDTO> getOrderDetailByOrderId(Integer orderId);

    List<OrderGoods> getAllInfo();
}
