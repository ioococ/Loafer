package moe.nekotako;

/**
 * @Author: nekotako
 * @Description: just test
 * @Date: 2023/8/30 14:34 星期三
 */

public class Dog extends Animals {

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void eat() {
        super.eat();
    }

    public void drink() {
        super.drink();
    }

    public void bite() {
        super.eat();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "color='" + color + '\'' +
                '}';
    }
}
