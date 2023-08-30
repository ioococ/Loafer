package moe.work.car;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/8/30 19:17 星期三
 */

public class Car {
    private String brand;
    private int speed = 60;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void manualPilot(String mode, int speed) {
        System.out.println("驾驶模式：" + mode);
        System.out.println("驾驶速度：" + speed);
    }
}

class SubCar extends Car {
    private boolean electric;

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    public void autoPilot(String mode, int speed) {
        System.out.println("驾驶模式：" + mode);
        System.out.println("驾驶速度：" + speed);
    }

    @Override
    public String toString() {
        return this.getBrand() + "：{Electric=" + electric + "，Speed=" + this.getSpeed() + "}";
    }
}
