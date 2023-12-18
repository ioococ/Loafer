package ink.onei.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private String orderName;
    private String orderDescribe;
    private Date orderTime;
    private Integer userId;
}
