package ink.onei.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer id;
    private String goodsName;
    private Integer goodsPrice;
    private String goodsDescribe;
    private Integer status;
    private Integer stock;
}
