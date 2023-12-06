package cn.my.update;

import java.util.List;

public interface UserDao{
    public int addUser(Spring user);
    public int updateUser(Spring user);
    public int deleteUserById(int id);
    public Spring findUserById(int id);
    public List<Spring> findAllUser();
}
