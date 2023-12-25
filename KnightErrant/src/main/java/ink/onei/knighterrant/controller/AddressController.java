package ink.onei.knighterrant.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ink.onei.knighterrant.dao.IAddressDao;
import ink.onei.knighterrant.vo.AddressDetailVO;
import ink.onei.knighterrant.vo.InfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: nekotako
 * @Description: 用户地址控制层
 * @Date: 25/12/2023 11:42 Monday
 */
@RestController()
@RequestMapping("address")
public class AddressController {
    @Autowired
    public IAddressDao addressDao;

    ObjectMapper objectMapper = new ObjectMapper();


    /**
     * 根据地址id 查询地址-用户 一对一关系
     * @param id 地址id
     * @return 地址-用户 一对一对象
     */
    @RequestMapping("detail")
    public String addressDetail(String id) {
        int i = Integer.parseInt(id);
        AddressDetailVO addressDetailVO = addressDao.getAddressDetail(i);
        InfoVo<AddressDetailVO> addressDetail = new InfoVo<>(200, "success", addressDetailVO);
//    @formatter:off
        try { return objectMapper.writeValueAsString(addressDetail);
        } catch (JsonProcessingException e) {throw new RuntimeException(e);}
//    @formatter:on
    }
}
