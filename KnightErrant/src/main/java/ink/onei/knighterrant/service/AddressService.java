package ink.onei.knighterrant.service;

import ink.onei.knighterrant.dao.IAddressDao;
import ink.onei.knighterrant.entity.Address;
import ink.onei.knighterrant.vo.AddressDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: nekotako
 * @Description: 用户地址业务层
 * @Date: 25/12/2023 11:47 Monday
 */

@Service
public class AddressService implements IAddressService{

    @Autowired
    private IAddressDao addressDao;

    /**
     * @param id 地址ID
     * @return 用户地址细节视图对象
     */
    @Override
    public AddressDetailVO getAddressDetail(Integer id) {
        return addressDao.getAddressDetail(id);
    }
}
