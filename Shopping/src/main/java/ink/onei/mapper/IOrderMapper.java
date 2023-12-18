package ink.onei.mapper;

import ink.onei.dto.OrderDetailDTO;
import ink.onei.entity.Order;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户数据库接口
 * @Date: 12/12/2023 11:08 Tuesday
 */

public interface IOrderMapper {

    Order getOrderById(Integer id);

    Order getOrderByUserId(Integer userId);

    OrderDetailDTO getOrderDetailByOrderId(Integer orderId);

    List<Order> getAllOrders();
}
