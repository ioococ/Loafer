package com.aotusoft.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

//在templates目录下的所有页面，只能通过Controller来访问
@Controller
public class HelloController {
//    @GetMapping("/hello")
//    public String hello() {
//        return "Hello World";
//    }
    @RequestMapping("/")
    public String index(){
        //在不加入thymeleaf模板引擎的情况下需要加入后缀名
        return "index.html";
    }
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","<p>This is a message</p>");
        model.addAttribute("users", Arrays.asList("aotusoft","qingjiang","shuax","runningcheese"));
        return "test";
    }
}
