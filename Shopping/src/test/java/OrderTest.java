import ink.onei.shopping.service.IOrderService;
import ink.onei.shopping.service.IUserService;
import ink.onei.shopping.vo.OrderDetailVO;
import ink.onei.shopping.vo.UserDetailVO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class OrderTest {
    ClassPathXmlApplicationContext applicationContext = null;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void getOrderDetail() {
        IOrderService bean = applicationContext.getBean(IOrderService.class);
        OrderDetailVO orderDetail = bean.getOrderDetail(5);
        System.out.println(orderDetail);
    }

    @Test
    public void getUserDetails() {
        IUserService bean = applicationContext.getBean(IUserService.class);
        int pageNum = 0;
        int pageSize = 5;
        List<UserDetailVO> userDetails = bean.getUserDetails(pageNum, pageSize);
        System.out.println(userDetails);
    }
}
