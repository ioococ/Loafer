package cn.ssm.controller;

import cn.ssm.pojo.Student;
import cn.ssm.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    @RequestMapping(value = "/save", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Student student) {
        studentService.save(student);
        return "SUCCESS";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<Student> studentList = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentList", studentList);
        modelAndView.setViewName("studentList");
        return modelAndView;
    }
}
