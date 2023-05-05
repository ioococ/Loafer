package com.test.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("person")
public class Person {
    private String name;
    private String denomination;
    private int age;
    private String profiles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person = {" +
                "name='" + name + '\'' +
                ", denomination='" + denomination + '\'' +
                ", age=" + age +
                '}';
    }
}
