package neko.fastboot.controller;

import neko.fastboot.dao.UserMapper;
import neko.fastboot.pojo.User;
import neko.fastboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: User Page
 * @Date: 2023/9/4 14:55 星期一
 */
@Controller
public class UserController {


    @Autowired
    private UserService userService;

    /*
     * 需要调用mapper中查所有的queryAll方法 需要创建UserMapper对象
     * 不需要实例化对象
     * */
    @Autowired
    private UserMapper mapper;

    @RequestMapping("/do")
    public String goIndex(Model model, @RequestParam("name") String name, @RequestParam("password") String password, HttpSession session) {
//    public String goIndex(Model model, User formData, HttpSession session) {
//        String name = formData.getName();
        User sqlData = userService.queryByName(name);
        if (sqlData == null && session.getAttribute("user") == null) {
            return "login";
        }
        if (password.equals(sqlData.getPassword())) {
            System.out.println(sqlData);
            session.setAttribute("user", sqlData);
            return "dashboard";
        } else {
            return "login";
        }
    }

    @RequestMapping("/query")
    public String fuzzyQuery(Model model, @RequestParam("name") String name, HttpSession session) {
        List<User> sqlData = userService.fuzzyQueryByName(name);
        model.addAttribute("name", name);
        model.addAttribute("users", sqlData);
        return "list";
    }

    @RequestMapping("/dashboard")
    public String dashboard(HttpSession session) {
        return "dashboard";
    }

    @RequestMapping("/list")
    public String list(Model model, HttpSession session) {
        return "list";
    }

    @RequestMapping({"/index"})
    public String index(Model model, HttpSession session) {

        List<User> users = userService.queryAll();
        model.addAttribute("users", users);

        if (session.getAttribute("user") != null) {
            return "all";
        } else {
            return "login";
        }
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
}
