package com.aotusoft.dao;

import com.aotusoft.pojo.Department;
import com.aotusoft.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    public static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        //员工有所属的部门
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "AA", "1@1.com", 0, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "2@2.com", 0, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "CC", "3@3.com", 0, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "DD", "4@4.com", 0, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "EE", "5@5.com", 0, new Department(105, "后勤部")));
    }

    //主键自增
    private static Integer initid = 1006;

    //增加员工
    public void add(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initid++);
        }
        employee.setDepartment(departmentDao.getDepartments(employee.getId()));
        employees.put(employee.getId(), employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll() {
        return employees.values();
    }

    //根据ID查询员工
    public Employee getEmployee(Integer id) {
        return employees.get(id);
    }

    //根据ID删除员工
    public Integer delete(Integer id) {
        if (employees.get(id) != null) {
            employees.remove(id);
            return 1;
        } else {
            return 0;
        }
    }
}
