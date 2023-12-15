package ink.onei.service;

import ink.onei.dto.UserAddressDTO;
import ink.onei.entity.Address;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户业务接口
 * @Date: 2023/11/10 14:41 星期五
 */

public interface IAddressService {

    Integer add(Address address);

    Integer modify(Address address);

    Integer delete(Address address);

    Address getAddressById(Integer id);

    List<Address> getAllAddress();

    Integer addBatch(List<Address> addressList);

    Integer addAddressByUser(UserAddressDTO userAddressDTO);
}
