package ink.onei.service;

import ink.onei.dto.OrderDetailDTO;
import ink.onei.entity.Order;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户业务接口
 * @Date: 2023/11/10 14:41 星期五
 */

public interface IOrderService {

    //    Integer add(User user);
//    Integer modify(User user);
//    Integer delete(User user);
    Order getOrderById(Integer id);

    Order getOrderByUserId(Integer userId);

    OrderDetailDTO getOrderDetailByOrderId(Integer orderId);

    List<Order> getAllOrders();

}
