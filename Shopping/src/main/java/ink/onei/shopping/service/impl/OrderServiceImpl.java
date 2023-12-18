package ink.onei.shopping.service.impl;

import ink.onei.shopping.mapper.IOrderMapper;
import ink.onei.shopping.service.IOrderService;
import ink.onei.shopping.vo.OrderDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    IOrderMapper orderMapper;

    @Override
    public OrderDetailVO getOrderDetail(Integer id) {
        return orderMapper.getOrderDetail(id);
    }
}
