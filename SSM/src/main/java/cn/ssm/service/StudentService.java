package cn.ssm.service;

import cn.ssm.pojo.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    List<Student> findAll();
}
