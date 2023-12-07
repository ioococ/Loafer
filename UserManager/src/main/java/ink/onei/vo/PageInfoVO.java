package ink.onei.vo;

import ink.onei.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfoVO {
    private List<User> userList;
    private Integer total;
}
