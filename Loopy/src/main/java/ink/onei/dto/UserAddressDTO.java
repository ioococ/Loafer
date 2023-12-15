package ink.onei.dto;

import ink.onei.entity.Address;
import ink.onei.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户-地址数据传输对象
 * @Date: 15/12/2023 11:39 Friday
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("userAddressDTO")
public class UserAddressDTO {
    private User user;
    private List<Address> addressList;
}
