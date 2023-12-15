package ink.onei.aspect;

import ink.onei.dao.IUserDao;
import ink.onei.dto.UserAddressDTO;
import ink.onei.entity.Address;
import ink.onei.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 地址方法切面
 * @Date: 15/12/2023 15:42 Friday
 */
@Aspect
@Component
public class AddressInterceptor {

    @Autowired
    IUserDao userDao;

    @Pointcut("execution(public * ink.onei.service.AddressService.addAddressByUser(..))")
    public void addAddressByUser() {

    }

    @Before("addAddressByUser()")
    public void before(JoinPoint joinPoint) {
        UserAddressDTO args = (UserAddressDTO) joinPoint.getArgs()[0];
        User user = args.getUser();
        List<Address> addressList = args.getAddressList();
        userDao.insert(user);
        for (Address address : addressList) {
            address.setUserId(user.getId());
        }

    }
}
