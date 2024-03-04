package ink.onei.order.service;

import ink.onei.order.client.UserClient;
import ink.onei.order.entity.Order;
import ink.onei.order.entity.User;
import ink.onei.order.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @date 23-7-25
 */
@Service
@AllArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final RestTemplate restTemplate;
    private final UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        order.setUser(userClient.selectUserById(order.getUserId()));

        // 4.返回
        return order;
    }
}
