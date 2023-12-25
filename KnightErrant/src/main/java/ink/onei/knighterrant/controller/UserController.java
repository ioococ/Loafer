package ink.onei.knighterrant.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ink.onei.knighterrant.entity.User;
import ink.onei.knighterrant.service.IUserService;
import ink.onei.knighterrant.vo.InfoVo;
import ink.onei.knighterrant.vo.UserDetailVO;
import ink.onei.knighterrant.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户控制层
 * @Date: 20/12/2023 15:30 Wednesday
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpSession session;

    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 分页用户列表 不传参为返回全部
     *
     * @param num  页数
     * @param size 每页数量
     * @return 用户列表
     */
    @RequestMapping("list")
    public String userList(@RequestParam(required = false) String num, @RequestParam(required = false) String size) {
        if (num != null) {
            int i = Integer.parseInt(num);
            int j = Integer.parseInt(size);
            PageHelper.startPage(i, j);
        }
        List<User> userList = userService.getUserList();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        UserInfoVO<User> userInfo = new UserInfoVO<>(200, "success", userList, pageInfo.getTotal());
//    @formatter:off
        try { return objectMapper.writeValueAsString(userInfo);
        } catch (JsonProcessingException e) {throw new RuntimeException(e);}
//    @formatter:on
    }

    /**
     * 根据用户id查询返回用户-地址一对多关系
     *
     * @param id 用户id
     * @return 用户-地址一对多对象
     */
    @RequestMapping("detail")
    public String userDetail(String id) {
        int i = Integer.parseInt(id);
        UserDetailVO userDetailVO = userService.getUserDetail(i);
        InfoVo<UserDetailVO> userDetail = new InfoVo<>(200, "success", userDetailVO);
//    @formatter:off
        try { return objectMapper.writeValueAsString(userDetail);
        } catch (JsonProcessingException e) {throw new RuntimeException(e);}
//    @formatter:on
    }

}
