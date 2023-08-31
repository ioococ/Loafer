package moe.work.dog;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/8/31 19:47 星期四
 */

public class Dog {
    private String name;
    private String breed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }


    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }
}
