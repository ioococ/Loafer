package cn.my.sb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制类
 */
@RestController
public class Indexcontroller {
    //请求，映射路径
    @RequestMapping("/hello")
    public String index() {
        return "Hello Spring Boot!";
    }
    @RequestMapping("/error")
    public String error() {
        return "404 Not Found";
    }
}
