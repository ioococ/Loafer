package ink.onei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/mvc")
public class HelloController {

    @Autowired
    HttpSession session = null;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/get")
    public String get() {
        session.setAttribute("method","GET");
        return "hello";
    }

    @PostMapping("/post")
    public String post() {
        session.setAttribute("method","POST");
        return "hello";
    }

    @RequestMapping("response")
    @ResponseBody
    public String response() {
        return "hello";
    }

    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect:/hello";
    }

    @RequestMapping("/forward")
    public String forward() {
        return "forward:hello";
    }
}