package ink.onei.shopping.mapper;

import ink.onei.shopping.vo.OrderDetailVO;
import org.apache.ibatis.annotations.Param;

public interface IOrderMapper {
    OrderDetailVO getOrderDetail(@Param("id") Integer id);
}
