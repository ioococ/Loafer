package ink.onei.dao;

import ink.onei.entity.Address;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: Address 接口
 * @Date: 05/12/2023 15:42 Tuesday
 */

public interface IAddressDao {
    Integer add(Address address);

    Integer updateAddressById(Address address);

    Integer deleteAddressById(Integer id);

    Address getAddressById(Integer id);

    List<Address> getAllAddress();
}
