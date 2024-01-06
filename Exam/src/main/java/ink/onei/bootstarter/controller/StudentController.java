package ink.onei.bootstarter.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ink.onei.bootstarter.entity.Students;
import ink.onei.bootstarter.service.StudentsService;
import ink.onei.bootstarter.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 06/01/2024 16:00 Saturday
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping("/add")
    public Result<Object> add(@RequestBody Students students) {
        Result<Object> result = new Result<>();
        Integer i = studentsService.add(students);
        result.setTotal(i);
        return result;
    }

    @RequestMapping("/modify")
    public Result<Object> modify(@RequestBody Students students) {
        Result<Object> result = new Result<>();
        Integer i = studentsService.modify(students);
        result.setTotal(i);
        return result;
    }

    @RequestMapping("/delete")
    public Result<Object> delete(@RequestBody Students students) {
        Result<Object> result = new Result<>();
        Integer i = studentsService.deleteById(students.getStudentId());
        result.setTotal(i);
        return result;
    }

    @RequestMapping("/getStudentsList")
    public Result<Students> getStudentsList(Integer pageNum, Integer pageSize, @RequestParam(required = false) Students students) {
        Result<Students> result = new Result<>();
        if (pageNum != null && pageSize != null) {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<Students> studentsList = studentsService.getStudentsList(students);
        PageInfo<Students> info = new PageInfo<>(studentsList);
        result.setRows(studentsList);
        result.setTotal(info.getTotal());
        return result;
    }
}
