package ink.onei.dao;

import ink.onei.entity.Address;
import ink.onei.vo.AddressAndUserVO;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: Address 接口
 * @Date: 05/12/2023 15:42 Tuesday
 */

public interface IAddressDao {
    Integer insert(Address address);

    Integer insertBatch(List<Address> addressList);

    Integer updateAddressById(Address address);

    Integer updateAddressDynamic(Address address);

    Integer deleteAddressById(Integer id);

    Integer deleteBatch(List<Integer> idList);

    Address getAddressById(Integer id);

    Address getAddressDynamic(Address address);

    List<Address> getAllAddress();

    List<Address> getAddressByUserid(Integer id);

    /**
     * @param id 地址id
     * @return 返回地址-用户 一对一对象
     */
    AddressAndUserVO AddrAndUserVo(Integer id);

    AddressAndUserVO AddrAndUserVoTwo(Integer id);
}
