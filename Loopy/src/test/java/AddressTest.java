import ink.onei.mapper.IUserDao;
import ink.onei.dto.UserAddressDTO;
import ink.onei.entity.Address;
import ink.onei.entity.User;
import ink.onei.service.IAddressService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * @Author: nekotako
 * @Description: 测试
 * @Date: 11/12/2023 19:44 Monday
 */

public class AddressTest {
    //    @Autowired
    Connection connection = null;

    IUserDao userDao = null;

    //    @Autowired
    IAddressService addressService = null;
    ApplicationContext applicationContext = null;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        addressService = applicationContext.getBean("addressService", IAddressService.class);
    }

    @Test
    public void beans() {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.print(name + "  ");
        }
    }

    @Test
    public void insertBatch() {
        ArrayList<Address> addressList = new ArrayList<>();
        addressList.add(new Address("a", "010000", 5));
        addressList.add(new Address("b", "020000", 5));
        addressList.add(new Address("c", "030000", 5));
        addressService.addBatch(addressList);
    }

    public void getBatch() {

    }

    @Test
    public void test() {
        ArrayList<Address> addressList = new ArrayList<>();
        addressList.add(new Address("c", "040000"));
        addressList.add(new Address("d", "050000"));
        addressList.add(new Address("e", "060000"));
        UserAddressDTO userAddressDTO = new UserAddressDTO(new User("c", "c"), addressList);
        addressService.addAddressByUser(userAddressDTO);
    }
}
