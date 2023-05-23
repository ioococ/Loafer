package com.aotusoft.controller;

import com.aotusoft.dao.EmployeeDao;
import com.aotusoft.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmpsController {
    @Autowired
    EmployeeDao employeeDao;
    @RequestMapping({"/emps","/emps.html"})
    public String listAll(Model model){
        Collection<Employee> allEmps = employeeDao.getAll();
        model.addAttribute("emps",allEmps);
        return "list";
    }
}
