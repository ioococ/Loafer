package cn.my.mybatis.mapper;

import cn.my.mybatis.pojo.Usertable;

import java.util.List;

public interface UserMapper {
    int insert();
    int update();
    int delete();
    List<Usertable> find();
}
