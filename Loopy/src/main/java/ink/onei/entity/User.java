package ink.onei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Author: nekotako
 * @Description: 用户实体类
 * @Date: 2023/11/10 14:44 星期五
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("user")
@Scope(value = "prototype")
public class User implements InitializingBean {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String email;
    private Date birthday;
    private String nickname;
    private Timestamp createdate = Timestamp.valueOf(LocalDateTime.now());


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String username, String password, String sex, String phone, String email, Date birthday, String nickname, Timestamp createdate) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.nickname = nickname;
        this.createdate = createdate;
    }

    public User(String username, String password, String sex, String phone, String email, Date birthday, String nickname) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.nickname = nickname;
    }

    @Override
    public void afterPropertiesSet() {
//        System.out.println(this);
    }
}
