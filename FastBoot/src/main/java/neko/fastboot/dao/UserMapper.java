package neko.fastboot.dao;

import neko.fastboot.pojo.User;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/9/4 15:23 星期一
 */

public interface UserMapper {
    User queryByPrimaryKey(Integer userID);

    User queryByName(String name);
}
