package cn.ssm.service;

import cn.ssm.mapper.StudentMapper;
import cn.ssm.pojo.Student;
import cn.ssm.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SSImpl implements StudentService{
    private StudentService studentService;
    @Autowired
    public SSImpl(StudentService studentService) {
        this.studentService = studentService;
        studentService.findAll();
    }
    @Override
    public void save(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.save(student);
    }

    @Override
    public List<Student> findAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        return studentMapper.findAll();
    }
}
