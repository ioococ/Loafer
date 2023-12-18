package ink.onei.service;

import ink.onei.entity.Goods;
import ink.onei.entity.Order;
import ink.onei.mapper.IGoodsMapper;
import ink.onei.mapper.IOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 16/12/2023 15:12 Saturday
 */

@Service
public class GoodsService implements IGoodsService {

    @Autowired
    IGoodsMapper goodsMapper;

    @Override
    public Goods getGoodsById(Integer id) {
        return goodsMapper.getGoodsById(id);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }
}
