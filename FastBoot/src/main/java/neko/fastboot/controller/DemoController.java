package neko.fastboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/9/4 15:34 星期一
 */
@Controller
public class DemoController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "hello";
    }
}
