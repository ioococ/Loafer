package ink.onei.entity;

/**
 * @Author: nekotako
 * @Description: Car
 * @Date: 18/12/2023 18:35 Monday
 */

public class Car {
    private String brand = null;
    private int doors = 0;

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDoors() {
        return this.doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("{");
        sb.append("brand=").append(brand).append(", doors=").append(doors).append('}');
        return sb.toString();
    }

    public Car() {
    }

    public Car(String brand, int doors) {
        this.brand = brand;
        this.doors = doors;
    }
}