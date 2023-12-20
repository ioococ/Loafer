package ink.onei.controller;

import ink.onei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/restful")
public class RestfulController {

    @Autowired
    HttpServletRequest request = null;

    @Autowired
    HttpServletResponse response = null;

    @RequestMapping( "/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/signup")
    public String signup(@RequestBody User user) {
        System.out.println(user);
        if (user != null) {
            return "{\"status\":\"ok\"}";
        } else {
            return "{\"status\":\"error\"}";
        }
    }

    @RequestMapping("/requestParam")
    public String requestParam(@RequestParam String username, @RequestParam String password, @RequestParam Integer age) {
        User user = new User(username, password, age);
        System.out.println(user);
        return "{\"status\":\"ok\"}";
    }
}