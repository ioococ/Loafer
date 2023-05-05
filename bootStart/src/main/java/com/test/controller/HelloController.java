package com.test.controller;

import com.test.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${name}")
    private String name;
    @Value("${person.name}")
    private String denomination;
    @Value("${spring.profiles}")
    private String profiles;

    @Autowired
    private Environment env;
    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public String Hello() {
        String s = "name:" + name;
        String str = "\r\n";
        String address = env.getProperty("address[0]");
        String string =
                newLine(profiles + "Environment") +
                newLine("hello SpringBoot") +
                newLine(s) +
                newLine(address) +
                newLine(person.toString());
        return string;
    }

    public String newLine(String s) {
        return "<p>" + s + "</p>";
    }
}
