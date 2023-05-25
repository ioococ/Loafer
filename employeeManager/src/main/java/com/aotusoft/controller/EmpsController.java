package com.aotusoft.controller;

import com.aotusoft.dao.DepartmentDao;
import com.aotusoft.dao.EmployeeDao;
import com.aotusoft.pojo.Department;
import com.aotusoft.pojo.Employee;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmpsController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping({"/emps", "/emps.html"})
    public String listAll(Model model) {
        Collection<Employee> allEmps = employeeDao.getAll();
        model.addAttribute("emps", allEmps);
        return "list";
    }

    @GetMapping("/emp")
    @RequestMapping("/add")
    public String toAdd(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "add";
    }

    @PostMapping("/emp")
    public String getInfo(HttpServletRequest request) {
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String birth = request.getParameter("birth");

        System.out.println(lastName + "\n" + email + "\n" + department + "\n" + birth);
        return "redirect:/emps";
    }
}
