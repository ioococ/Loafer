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


    @RequestMapping("/2add")
    public String toAdd() {
        return "add";
    }

    @RequestMapping("/add")
    public String add(Model model,
                      @RequestParam("name") String name,
                      @RequestParam("password") String password,
                      @RequestParam("age") int age,
                      @RequestParam("sex") String sex,
                      @RequestParam("email") String email,
                      HttpSession session) {
        java.util.Date currentDate = new java.util.Date();
        java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());
        User u = new User(0, name, password, age, sex, email, sqlCurrentDate);
        userService.addUser(u);
        return "redirect:/dashboard";
    }

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
            return "redirect:/dashboard";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping("/2query")
    public String doFuzzyQuery(Model model, HttpSession session) {
        return "query";
    }

    @RequestMapping("/query")
    public String fuzzyQuery(Model model, @RequestParam("name") String name, HttpSession session) {
        List<User> sqlData = userService.fuzzyQueryByName(name);
        model.addAttribute("name", name);
        model.addAttribute("users", sqlData);
        return "query";
    }

    @RequestMapping({"/", "/index", "/dashboard"})
    public String index(Model model, HttpSession session) {

        if (session.getAttribute("user") != null) {
            return "dashboard";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping("/alluser")
    public String list(Model model, HttpSession session) {

        List<User> users = userService.queryAll();
        model.addAttribute("users", users);
        return "alluser";
    }

    @RequestMapping("/modify")
    public String modify(Model model, HttpSession session) {

        User user = userService.queryByPrimaryKey(1);
        model.addAttribute("user", user);
        return "alluser";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.removeAttribute("user");
        return "redirect:login";
    }
}
