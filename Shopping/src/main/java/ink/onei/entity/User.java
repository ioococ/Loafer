package ink.onei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author: nekotako
 * @Description: 用户实体类
 * @Date: 2023/11/10 14:44 星期五
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("user")
public class User {
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private String sex;
    private Integer age;
    private Integer money;

    public User(String username, String nickname, String password, String sex, Integer age, Integer money) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", username=" + username + "}";
    }
}
