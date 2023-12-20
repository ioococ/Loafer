package ink.onei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 20/12/2023 17:14 Wednesday
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
//    @RequestMapping("/")
//    public String login(){
//        return "login";
//    }
}
