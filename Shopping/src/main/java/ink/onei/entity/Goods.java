package ink.onei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author: nekotako
 * @Description: 商品实体类
 * @Date: 2023/11/10 14:44 星期五
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("goods")
public class Goods {
    private Integer id;
    private String goodNames;
    private Integer goodPrice;
    private String goodsDescribe;
    private Integer status;
    private Integer stock;

    @Override
    public String toString() {
        return "{id=" + id + ", goodNames=" + goodNames + "}";
    }

    public Goods(String goodNames, int goodPrice, String goodsDescribe, int status, Integer stock) {
        this.goodNames = goodNames;
        this.goodPrice = goodPrice;
        this.goodsDescribe = goodsDescribe;
        this.status = status;
        this.stock = stock;


    }
}
