package ink.onei.shopping.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailVO {
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private String sex;
    private Integer age;
    private Integer money;
    private List<OrderVO> orderVOList;
}
