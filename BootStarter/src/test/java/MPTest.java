import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import ink.onei.bootstarter.entity.User;
import ink.onei.bootstarter.mapper.IUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 04/01/2024 16:57 Thursday
 */

@MybatisPlusTest
public class MPTest {

    @Autowired
    private IUserMapper IUserMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("abc");
        IUserMapper.insert(user);
        assertThat(user.getId()).isNotNull();
    }
}
