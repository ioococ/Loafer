package manager.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/10 14:44 星期五
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String email;
    private java.sql.Timestamp birthday;
    private String nickname;
    private java.sql.Timestamp createdate = Timestamp.valueOf(LocalDateTime.now());


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
