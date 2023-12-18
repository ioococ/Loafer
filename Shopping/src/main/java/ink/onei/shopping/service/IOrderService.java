package ink.onei.shopping.service;

import ink.onei.shopping.vo.OrderDetailVO;
import org.apache.ibatis.annotations.Param;

public interface IOrderService {
    OrderDetailVO getOrderDetail(Integer id);
}
