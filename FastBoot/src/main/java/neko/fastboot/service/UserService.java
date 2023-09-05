package neko.fastboot.service;

import neko.fastboot.pojo.User;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/9/4 14:58 星期一
 */

public interface UserService {
    public User queryByPrimaryKey(int uID);
    public User queryByName(String name);
    public List<User> fuzzyQueryByName(String name);
    public List<User> queryAll();
}
