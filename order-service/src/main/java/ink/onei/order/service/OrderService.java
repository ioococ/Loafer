package ink.onei.order.service;

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

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        String url = "http://user-service/user/"+order.getUserId();
        User user = restTemplate.getForObject(url, User.class);

        order.setUser(user);

        // 4.返回
        return order;
    }
}
