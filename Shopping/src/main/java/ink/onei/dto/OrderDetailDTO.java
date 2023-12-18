package ink.onei.dto;

import ink.onei.entity.Goods;
import ink.onei.entity.Order;
import ink.onei.entity.OrderGoods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 16/12/2023 15:33 Saturday
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
    private Integer id;
    private String username;
    private List<OrderGoods> orderGoods;
    private List<Goods> goodsList;
}
