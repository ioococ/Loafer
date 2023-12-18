import ink.onei.dto.OrderDetailDTO;
import ink.onei.dto.UserDetailDTO;
import ink.onei.service.IOrderAndGoodsService;
import ink.onei.service.IOrderService;
import ink.onei.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: nekotako
 * @Description: 测试
 * @Date: 11/12/2023 19:44 Monday
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DBTest {

    IOrderService orderService = null;
    IUserService userService = null;
    IOrderAndGoodsService ogService = null;
    ApplicationContext applicationContext = null;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        orderService = applicationContext.getBean("orderService", IOrderService.class);
        userService = applicationContext.getBean("userService", IUserService.class);
        ogService = applicationContext.getBean("orderAndGoodsService", IOrderAndGoodsService.class);
    }

    @Test
    public void getDetailByOrderId() {
        OrderDetailDTO dto = orderService.getOrderDetailByOrderId(5);
        System.out.println(dto);
    }

    @Test
    public void getDetailByUserId() {
        UserDetailDTO dto = userService.getDetailByUserId(2);
        System.out.println(dto);
    }

}
