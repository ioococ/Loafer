package ink.onei.mapper;

import ink.onei.dto.OrderDetailDTO;
import ink.onei.entity.Order;
import ink.onei.entity.OrderGoods;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户数据库接口
 * @Date: 12/12/2023 11:08 Tuesday
 */

public interface IOrderAndGoodsMapper {

    OrderGoods getInfoById(Integer id);

    List<OrderGoods> getInfoByOrderId(Integer orderId);

    List<OrderDetailDTO> getOrderDetailByOrderId(Integer orderId);

    List<OrderGoods> getAllInfo();
}
