package ink.onei.mapper;

import ink.onei.entity.Address;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 地址数据库接口
 * @Date: 15/12/2023 10:41 Friday
 */

public interface IAddressDao {
    Integer insert(Address address);

    Integer update(Address address);

    Integer delete(Address address);

    List<Address> getAddressByUserId(Integer id);

    List<Address> getAllAddress();

    Integer insertBatch(List<Address> addressList);
}
