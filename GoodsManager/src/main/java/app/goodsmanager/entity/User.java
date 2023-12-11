package app.goodsmanager.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: nekotako
 * @Description: 用户实体类
 * @Date: 2023/11/10 14:44 星期五
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String username;
    private String password;
    private String nickname;

}
