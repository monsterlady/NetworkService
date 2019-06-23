package com.example.demo;

import com.example.demo.model.Good;
import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class Constant {
    public static List<Good> goods = new ArrayList<>();

    static {
        goods.add(new Good(0, "Football", 10, 10, "Sport", "Football Description", "user1"));
        goods.add(new Good(1, "Basketball", 10, 20, "Sport", "Basketball Description", "user2"));
        goods.add(new Good(2, "Bicycle", 30, 30, "Sport", "Bicycle Description", "user1"));
        goods.add(new Good(3, "Running", 40, 15, "Sport", "Running Description", "user2"));
        goods.add(new Good(4, "Swimming", 50, 20, "Sport", "Swimming Description", "user1"));
        goods.add(new Good(5, "Jumping", 50, 20, "Sport", "Swimming Description", "user2"));
        goods.add(new Good(6, "Volleyball", 50, 20, "Sport", "Swimming Description", "user1"));
        goods.add(new Good(7, "Soccer", 50, 20, "Sport", "Swimming Description", "user2"));
    }

    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User("user1", "password1", "USER"));
        users.add(new User("user2", "password2", "USER"));
        users.add(new User("admin", "adminPassword1", "ADMIN"));
    }

}
