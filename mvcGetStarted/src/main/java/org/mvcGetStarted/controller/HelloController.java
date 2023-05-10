package org.mvcGetStarted.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping({"/", "index"})
    public String indexPage(){
        return "/static/index";
//        return "forward:/target";
    }
    @RequestMapping("/target")
    public String toTarget(){
        return "/static/target";
    }
}
