package ink.onei.shopping.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVO {
    private Integer id;
    private String goodsName;
    private Integer goodsPrice;
    private String goodsDescribe;
    private Integer status;
    private Integer stock;
    private Integer goodsNum;
}
