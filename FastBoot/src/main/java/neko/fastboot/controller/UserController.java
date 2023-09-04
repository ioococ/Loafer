package neko.fastboot.controller;

import neko.fastboot.pojo.User;
import neko.fastboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: nekotako
 * @Description: User Page
 * @Date: 2023/9/4 14:55 星期一
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
//    @RequestMapping("/do")
//    @ResponseBody
//    public String doing(){
//        return "success";
//    }

    @RequestMapping("/do")
    public String goIndex(Model model, @RequestParam("name") String name, @RequestParam("password") String password) {
        model.addAttribute("name", name);
        User user = userService.queryByName(name);
        if (user == null){
            return "login";
        }
        if (password.equals(user.getPassword())) {
            System.out.println(user);
            model.addAttribute("email", user.getEmail());
            return "index";
        } else {
            return "login";
        }
    }

    @RequestMapping({"/", "/index", "/index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("", "");
        return "login";
    }
}
