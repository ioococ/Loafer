package ink.onei.order.service;

import ink.onei.order.entity.Order;
import ink.onei.order.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @date 23-7-25
 */
@Service
@AllArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 4.返回
        return order;
    }
}
