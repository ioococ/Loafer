package cn.mybatis.mapper;

import cn.mybatis.pojo.Usertable;

import java.util.List;

public interface UserMapper {
    int insert();
    int insertOne(String name,String password);
    int update();
    int updatetOne(String name,String password);
    int delete();
    List<Usertable> find();
    Usertable findOne(int stuId);
    Usertable findOn(int stuId,String name);
}
