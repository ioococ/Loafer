package ink.onei.bootstarter.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ink.onei.bootstarter.service.CourseSelectionsService;
import ink.onei.bootstarter.vo.Result;
import ink.onei.bootstarter.vo.ScoreDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 06/01/2024 17:50 Saturday
 */

@RestController
@RequestMapping("/selections")
public class CourseSelectionsController {
    @Autowired
    private CourseSelectionsService csService;

    @RequestMapping("getScoreList")
    public Result<ScoreDetailVO> getScoreList(String pageNum, String pageSize, @RequestBody Integer status) {
        Result<ScoreDetailVO> result = new Result<>();
        ScoreDetailVO scoreDetailVO = new ScoreDetailVO();
        scoreDetailVO.setStatus(status);
        if (pageNum != null && pageSize != null) {
            PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        }
        List<ScoreDetailVO> scoreList = csService.getScoreList(scoreDetailVO);
        PageInfo<ScoreDetailVO> info = PageInfo.of(scoreList);
        result.setRows(scoreList);
        result.setTotal(info.getTotal());
        return result;
    }
}
