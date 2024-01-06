package ink.onei.bootstarter.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ink.onei.bootstarter.service.ClassesService;
import ink.onei.bootstarter.vo.ClassDetailVO;
import ink.onei.bootstarter.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 06/01/2024 16:48 Saturday
 */

@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    @RequestMapping("/getClassesList")
    public Result<ClassDetailVO> getClassesList(Integer pageNum, Integer pageSize) {
        Result<ClassDetailVO> result = new Result<>();
        if (pageNum != null && pageSize != null) {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<ClassDetailVO> classesList = classesService.getClassesList();
        PageInfo<ClassDetailVO> info = new PageInfo<>(classesList);
        result.setRows(classesList);
        result.setTotal(info.getTotal());
        return result;
    }
}
