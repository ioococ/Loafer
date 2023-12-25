package ink.onei.knighterrant.service;

import ink.onei.knighterrant.vo.AddressDetailVO;

/**
 * @Author: nekotako
 * @Description: 用户地址业务层
 * @Date: 25/12/2023 11:47 Monday
 */

public interface IAddressService {
    AddressDetailVO getAddressDetail(Integer id);

}
