package ink.onei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mvc")
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/get")
    public String get() {
        return "hello";
    }

    @PostMapping("/post")
    public String post() {
        return "hello";
    }

    @RequestMapping("response")
    @ResponseBody
    public String response() {
        return "hello";
    }
}