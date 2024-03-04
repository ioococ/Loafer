package ink.onei.order.client;

import ink.onei.order.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 04/03/2024 11:26 Monday
 */
@FeignClient("user-service")
public interface UserClient {
    @GetMapping("/user/{id}")
    User selectUserById(@PathVariable("id") Long userId);
}
