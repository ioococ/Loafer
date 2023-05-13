package com.aotusoft.bootgetstarted.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
//YAML
@ConfigurationProperties(prefix = "person")
//加载指定配置文件
//@PropertySource(value = "classpath:aotu.properties")
@Validated
public class Person {
    //SPEL表达式取出值
//    @Value("${name}")
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private List<Object> list;
    private Map<String,Object> maps;
    private UUID uuid;
    @Email
    private String email;
    private Dog dog;

    public Person() {
    }

    public Person(String name, Integer age, Boolean happy, Date birth, List<Object> list, Map<String, Object> maps, UUID uuid, String email, Dog dog) {
        this.name = name;
        this.age = age;
        this.happy = happy;
        this.birth = birth;
        this.list = list;
        this.maps = maps;
        this.uuid = uuid;
        this.email = email;
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getHappy() {
        return happy;
    }

    public void setHappy(Boolean happy) {
        this.happy = happy;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", happy=" + happy +
                ", birth=" + birth +
                ", list=" + list +
                ", maps=" + maps +
                ", uuid=" + uuid +
                ", email='" + email + '\'' +
                ", dog=" + dog +
                '}';
    }
}








