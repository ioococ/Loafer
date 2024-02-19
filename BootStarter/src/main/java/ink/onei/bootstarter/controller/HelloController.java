package ink.onei.bootstarter.controller;

import ink.onei.bootstarter.entity.Menu;
import ink.onei.bootstarter.entity.User;
import ink.onei.bootstarter.etc.Constants;
import ink.onei.bootstarter.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 03/01/2024 09:00 Wednesday
 */

@Controller
public class HelloController {

    @Autowired
    private IMenuService menuService;

    @RequestMapping("/hello")
    public String hello(Model model) {
        var user = new User();
        user.setUsername("onei");
        user.setNickname("ioococ");
        model.addAttribute("msg", "SpringBoot");
        model.addAttribute("user", user);
        return "demo";
    }

    @RequestMapping("/hi")
    public String hi(Model model) {
        model.addAttribute("msg", "Hi SpringBoot");
        return "hello";
    }

    @RequestMapping({"/","/index"})
    public String index(Model model) {
        List<Menu> menuList = menuService.getMenuList();
        model.addAttribute(Constants.MENU_LIST_KEY,menuList);
        return "index";
    }

    @RequestMapping("/login")
    public String userLogin() {
        return "login";
    }

//    @RequestMapping("/user/list")
//    public String userList() {
//        return "list";
//    }
}
