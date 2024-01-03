package ink.onei.bootstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 03/01/2024 11:03 Wednesday
 */

@Controller
public class ErrorController {
    @RequestMapping("404")
    public String notFound(){
        return "404";
    }
}
