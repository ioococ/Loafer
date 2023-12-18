package ink.onei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Author: nekotako
 * @Description: 订单实体类
 * @Date: 2023/11/10 14:44 星期五
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("order")
public class Order {
    private Integer id;
    private String orderName;
    private String orderDescribe;
    private java.sql.Timestamp orderTime = Timestamp.valueOf(LocalDateTime.now());;
    private Integer userId;

    public Order(String orderName, String orderDescribe, Timestamp orderTime, int userId) {
        this.orderName = orderName;
        this.orderDescribe = orderDescribe;
        this.orderTime = orderTime;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
