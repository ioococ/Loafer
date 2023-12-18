package ink.onei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.*;

@Controller
@RequestMapping("/mvc")
public class HelloController {
    @RequestMapping("hello")
    public String m1(){

        return "hello";
    }
}