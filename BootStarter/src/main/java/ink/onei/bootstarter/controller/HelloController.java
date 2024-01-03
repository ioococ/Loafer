package ink.onei.bootstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 03/01/2024 09:00 Wednesday
 */

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("msg", "Hello SpringBoot");
        return "hello";
    }

    @RequestMapping("/hi")
    public String hi(Model model) {
        model.addAttribute("msg", "Hi SpringBoot");
        return "hello";
    }
}
