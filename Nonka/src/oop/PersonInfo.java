package oop;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/10/9 9:50 星期一
 */

public class PersonInfo {
    private String name;
    private int sex;
    private int age;
    private String address;
    private String degree;

    public PersonInfo(String name, int sex, int age, String address, String degree) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.degree = degree;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}

