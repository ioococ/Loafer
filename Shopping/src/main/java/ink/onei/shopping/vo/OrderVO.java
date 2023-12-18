package ink.onei.shopping.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    private Integer id;
    private String orderName;
    private String orderDescribe;
    private Date orderTime;
    private Integer userId;
    private List<GoodsVO> goodsVOList;
}
