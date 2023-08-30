package moe.work.fruit;

/**
 * @Author: nekotako
 * @Description: 水果类
 * @Date: 2023/8/30 18:52 星期三
 */

public class Fruit {
    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape(String shape) {
        return shape;
    }

    public void getAdditionProperty(String shape, String flavor) {
        System.out.println(shape + "\t" + flavor);
    }
}
