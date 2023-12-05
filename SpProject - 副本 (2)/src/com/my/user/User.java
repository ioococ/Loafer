package com.my.user;

public class User {
    private String username;
    private Integer password;

    public User() {

    }

    //构造注入
    public User(String username, Integer password) {
        super();
        this.username = username;
        this.password = password;
    }

    //setter注入
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public Integer getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode())+": { username='" + username + "', password=" + password + " }";
    }
}
