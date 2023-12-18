import ink.onei.entity.Address;
import ink.onei.rowMapper.AddressRowMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Mr.Wang
 * @date 23-12-15
 */
public class UserTest {
    @Test
    public void getOne(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate bean = applicationContext.getBean(JdbcTemplate.class);
        bean.update("insert into t_user (username) values(?)","启帅");
        List<Address> query = bean.query("select * from t_address", new AddressRowMapper());
        System.out.println(query);

    }
}
