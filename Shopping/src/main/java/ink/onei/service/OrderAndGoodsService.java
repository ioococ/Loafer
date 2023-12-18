package ink.onei.service;

import ink.onei.dto.OrderDetailDTO;
import ink.onei.entity.Order;
import ink.onei.entity.OrderGoods;
import ink.onei.mapper.IGoodsMapper;
import ink.onei.mapper.IOrderAndGoodsMapper;
import ink.onei.mapper.IOrderMapper;
import ink.onei.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 16/12/2023 15:12 Saturday
 */

@Service
public class OrderAndGoodsService implements IOrderAndGoodsService {

    @Autowired
    IOrderAndGoodsMapper ogMapper;

    @Autowired
    IOrderMapper orderMapper;

    @Autowired
    IGoodsMapper goodsMapper;

    @Autowired
    IUserMapper userMapper;

    @Autowired
    OrderDetailDTO orderDetailDTO;


    /**
     * @param id
     * @return
     */
    @Override
    public OrderGoods getInfoById(Integer id) {
        return null;
    }

    /**
     * @param orderId
     * @return
     */
    @Override
    public OrderGoods getInfoByOrderId(Integer orderId) {
        return null;
    }


    /**
     * @param orderId
     * @return
     */
    @Override
    public List<OrderDetailDTO> getOrderDetailByOrderId(Integer orderId) {
        List<OrderGoods> orderGoods = ogMapper.getInfoByOrderId(orderId);
        Order order = orderMapper.getOrderById(orderId);
//        orderDetailDTO.setUser(userMapper.getUserById(order.getUserId()));
        return ogMapper.getOrderDetailByOrderId(orderId);
    }

    /**
     * @return
     */
    @Override
    public List<OrderGoods> getAllInfo() {
        return null;
    }
}
