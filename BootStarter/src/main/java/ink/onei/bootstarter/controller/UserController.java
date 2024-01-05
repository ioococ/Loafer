package ink.onei.bootstarter.controller;

import com.github.pagehelper.PageHelper;
import ink.onei.bootstarter.etc.Constants;
import ink.onei.bootstarter.etc.OperaException;
import ink.onei.bootstarter.entity.User;
import ink.onei.bootstarter.service.IUserService;
import ink.onei.bootstarter.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * (User)表控制层
 *
 * @author nekotako
 * @since 2024-01-04 09:33:58
 */
@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    HttpSession session;

    @Autowired
    private IUserService userService;

    @RequestMapping("AjaxLogin")
    public Result<Object> login(@RequestBody User user) {
        Result<Object> result = new Result<>();
        Boolean login = false;
        try {
            login = userService.login(user);
        } catch (OperaException e) {
            Integer code = Objects.equals(e.getMessage(), "用户不存在") ? 401 : 402;
            result.setCode(code);
            result.setMsg(e.getMessage());
        }
        if (login) session.setAttribute(Constants.LOGIN_USER_SESSION_KEY, user);
        return result;
    }

    @RequestMapping("userList")
    public Result<User> userList(Integer pageNum, Integer pageSize, @RequestParam(required = false) User user) {
        Result<User> result = new Result<>();
        if (pageNum != null && pageSize != null)
            PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userService.getUserList(user);
        result.setRows(userList);
        return result;
    }
}

