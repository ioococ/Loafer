package ink.onei.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private String sex;
    private Integer age;
    private Integer money;
}