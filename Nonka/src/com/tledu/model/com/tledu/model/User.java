package com.tledu.model;

public class User {
    private String username;
    private String password;
    private String nickname;
    private int age;
    private String addr;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    static public void login(User user) {
        if (user.username.equals("admin")) {
            if (user.username.equals("root")) {
                System.out.println("登陆成功");
            } else {
                System.out.println("密码不对");
            }
        } else {
            System.out.println("用户名不正确");
        }
    }
    // public void login(User user) {
    // if (username.equals("admin")) {
    // if (password.equals("root")) {
    // System.out.println("登陆成功");
    // } else {
    // System.out.println("密码不对");
    // }
    // } else {
    // System.out.println("用户名不正确");
    // }
    // }
}
