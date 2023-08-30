package moe.nekotako;

/**
 * @Author: nekotako
 * @Description: just test
 * @Date: 2023/8/30 14:33 星期三
 */

public class Animals {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
    }

    public void drink() {
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
