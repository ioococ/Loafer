package ink.onei.mapper;

import ink.onei.entity.Goods;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户数据库接口
 * @Date: 12/12/2023 11:08 Tuesday
 */

public interface IGoodsMapper {

    Goods getGoodsById(Integer id);

    List<Goods> getAllGoods();
}
