package ink.onei.shopping.service.impl;

import ink.onei.shopping.entity.User;
import ink.onei.shopping.mapper.IUserMapper;
import ink.onei.shopping.service.IUserService;
import ink.onei.shopping.vo.UserDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserMapper userMapper;

    @Override
    public List<UserDetailVO> getUserDetails(Integer pageNum, Integer pageSize) {
        List<User> userList = userMapper.getUserList(pageNum, pageSize);
        List<Integer> idList=new ArrayList<>();
        for (User user:userList) {
            idList.add(user.getId());
        }
        return userMapper.getUserDetails(idList);
    }
}
