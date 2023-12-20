package ink.onei.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ink.onei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/restful")
public class RestfulController {

    @Autowired
    HttpServletRequest request = null;

    @Autowired
    HttpServletResponse response = null;

    @Autowired
    HttpSession session = null;

    @Autowired
    private ApplicationContext applicationContext = null;

    @RequestMapping({"/hello", "/hi"})
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
    public String requestParam(@RequestParam String username, @RequestParam String password, @RequestParam Integer age, @RequestParam String birthday) {
        User user = new User();
        System.out.println(user);
        return "{\"status\":\"ok\"}";
    }

    @RequestMapping("/converter")
    public String converter(@RequestParam String username, @RequestParam String password, @RequestParam Integer age, @RequestParam String birthday) {
        User user = new User();
        System.out.println(user);
        return "{\"status\":\"ok\"}";
    }

    @RequestMapping("/getBeanContainer")
    public String container() {
        String[] names = applicationContext.getBeanDefinitionNames();
        ObjectMapper objectMapper = new ObjectMapper();
        String name = null;
        try {
            name = objectMapper.writeValueAsString(names);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return "{\"status\":\"ok\",\"beans\":" + name + "}";
    }
}