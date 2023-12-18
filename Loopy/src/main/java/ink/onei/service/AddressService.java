package ink.onei.service;

import ink.onei.mapper.IAddressDao;
import ink.onei.mapper.IUserDao;
import ink.onei.dto.UserAddressDTO;
import ink.onei.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户业务类
 * @Date: 2023/11/10 14:41 星期五
 */

@Service
public class AddressService implements IAddressService {

    @Autowired
    IAddressDao addressDao;
    @Autowired
    IUserDao userDao;

    /**
     * @param address
     * @return
     */
    @Override
    public Integer add(Address address) {
        return null;
    }

    /**
     * @param address
     * @return
     */
    @Override
    public Integer modify(Address address) {
        return null;
    }

    /**
     * @param address
     * @return
     */
    @Override
    public Integer delete(Address address) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Address getAddressById(Integer id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Address> getAllAddress() {
        return null;
    }

    public Integer addBatch(List<Address> addressList) {
        return addressDao.insertBatch(addressList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addAddressByUser(UserAddressDTO userAddressDTO) {
        List<Address> addressList = userAddressDTO.getAddressList();
        Integer i = addressDao.insertBatch(addressList);
        if (i != addressList.size()) {
            throw new RuntimeException("地址插入失败");
        }
        return i;
    }

    @PostConstruct
    public void init() {
//        System.out.println("初始化");
//        System.out.println(this);
//        System.out.println("AddressDao对象为 " + addressDao);
    }

    @PreDestroy
    public void destroy() {
//        System.out.println("销毁");
    }
}
