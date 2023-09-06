package neko.fastboot.dao;

import neko.fastboot.pojo.User;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: mybatis 接口代理  实体跟数据库 映射
 * @Date: 2023/9/4 15:23 星期一
 */

public interface UserMapper {
    User queryByPrimaryKey(Integer userID);

    User queryByName(String name);

    List<User> fuzzyQueryByName(String name);

    List<User> queryAll();

    void addUser(User user);

    void modifyUser(User user);
}
