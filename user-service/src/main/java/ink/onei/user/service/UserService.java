package ink.onei.user.service;

import ink.onei.user.entity.User;
import ink.onei.user.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date 23-7-25
 */
@Service
@AllArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public User queryById(Long id) {
        return userMapper.findById(id);
    }
}
