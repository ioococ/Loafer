package neko.fastboot.service;

import neko.fastboot.dao.UserMapper;
import neko.fastboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/9/4 15:01 星期一
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;
    @Override
    public User queryByPrimaryKey(int uID) {
        return userMapper.queryByPrimaryKey(uID);
    }

    @Override
    public User queryByName(String name) {
        return userMapper.queryByName(name);
    }
}
