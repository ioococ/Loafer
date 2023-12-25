package ink.onei.knighterrant.dao;

import ink.onei.knighterrant.vo.AddressDetailVO;

/**
 * (Address)表数据库访问层
 *
 * @author makejava
 * @since 2023-12-25 10:23:21
 */
public interface IAddressDao {

    AddressDetailVO getAddressDetail(Integer id);

}

