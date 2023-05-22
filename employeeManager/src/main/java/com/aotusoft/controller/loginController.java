package com.aotusoft.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

@Controller
public class loginController {
    @RequestMapping("/login")
//    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model,HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser",username);
            return "dashboard";
        } else {
            model.addAttribute("msg", "登录失败 \n用户名：" + username + "\n密码：" + password);
            return "index";
        }
    }
}
