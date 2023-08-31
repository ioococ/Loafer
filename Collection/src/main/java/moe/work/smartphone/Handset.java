package moe.work.smartphone;

/**
 * @Author: nekotako
 * @Description: 手机
 * @Date: 2023/8/31 18:45 星期四
 */

public class Handset {
    private String brand;
    private String type;

    public void sendInfo() {
        System.out.println("");
    }

    public void call() {
        System.out.println("");
    }

    public void info() {
        System.out.println("这是一款型号为"+this.getBrand()+"手机");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
