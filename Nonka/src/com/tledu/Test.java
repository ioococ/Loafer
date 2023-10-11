package com.tledu;

import com.tledu.model.User;

public class Test {
    public static void main(String[] args) {
        User u = new User("admin","root");
        // u.login(u);
        User.login(u);
    }
}
