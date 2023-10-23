package serialize;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serializeUID = 2;

    private String name;
    private int age;
    private String address;
    private long phone;
    
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public User() {
    }

    public User(String name, int age, String address, long phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", address=" + address + ", phone=" + phone + "]";
    }
    
    
}
