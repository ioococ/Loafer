package cn.ssm.mapper;

import cn.ssm.pojo.Student;

import java.util.List;

public interface StudentMapper {
    void save(Student student);
    List<Student> findAll();
}
