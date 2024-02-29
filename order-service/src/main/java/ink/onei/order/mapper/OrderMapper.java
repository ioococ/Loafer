package ink.onei.order.mapper;

import  ink.onei.order.entity.Order;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {

    @Select("select * from demo_order where id = #{id}")
    Order findById(Long id);
}
