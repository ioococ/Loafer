package ink.onei.service;

import ink.onei.dto.UserDetailDTO;
import ink.onei.entity.User;
import ink.onei.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户业务类
 * @Date: 2023/11/10 14:41 星期五
 */

@Service
public class UserService implements IUserService {

    @Autowired
    IUserMapper userMapper;

    /**
     * @param user
     * @return
     */

    /**
     * @param id
     * @return
     */
    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public UserDetailDTO getDetailByUserId(Integer userId) {
        return userMapper.getDetailByUserId(userId);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;
        users = userMapper.getAllUsers();
        return users;
    }
}
