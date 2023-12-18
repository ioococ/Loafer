package ink.onei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author: nekotako
 * @Description: 订单-商品实体类
 * @Date: 2023/11/10 14:44 星期五
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("orderGoods")
public class OrderGoods {
    private Integer id;
    private Integer orderId;
    private Order order;
    private Integer goodsId;
    private Goods goods;
    private Integer goodNum;

    public OrderGoods(Integer orderId, Integer goodsId, Integer goodNum) {
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.goodNum = goodNum;
    }

    public OrderGoods(Order order, Goods goods, Integer goodNum) {
        this.order = order;
        this.goods = goods;
        this.goodNum = goodNum;
    }

    @Override
    public String toString() {
        return "OrderGoods{" + "id=" + id + ", order=" + order + ", goods=" + goods + ", goodNum=" + goodNum + "}";
    }
}
