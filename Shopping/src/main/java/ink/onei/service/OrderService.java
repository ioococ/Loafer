package ink.onei.service;

import ink.onei.dto.OrderDetailDTO;
import ink.onei.entity.Order;
import ink.onei.mapper.IGoodsMapper;
import ink.onei.mapper.IOrderAndGoodsMapper;
import ink.onei.mapper.IOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 16/12/2023 15:12 Saturday
 */

@Service
public class OrderService implements IOrderService {

    @Autowired
    IOrderMapper orderMapper;

    @Autowired
    IGoodsMapper goodsMapper;

    @Autowired
    IOrderAndGoodsMapper ogMapper;

    /**
     * @param id
     * @return
     */
    @Override
    public Order getOrderById(Integer id) {
        return orderMapper.getOrderById(id);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public Order getOrderByUserId(Integer userId) {
        return orderMapper.getOrderByUserId(userId);
    }

    public OrderDetailDTO getOrderDetailByOrderId(Integer orderId) {
        return orderMapper.getOrderDetailByOrderId(orderId);
    }


    /**
     * @return
     */
    @Override
    public List<Order> getAllOrders() {
        return orderMapper.getAllOrders();
    }
}
