package com.example.demo.service;

import com.example.demo.Constant;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    public UserService(InMemoryUserDetailsManager inMemoryUserDetailsManager) {
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }


    public void addUser(String username, String password) {
        if (inMemoryUserDetailsManager.userExists(username)) {
            return;
        }
        inMemoryUserDetailsManager.createUser(User.withUsername(username).password(new BCryptPasswordEncoder().encode(password)).roles("USER").build());
        Constant.users.add(new com.example.demo.model.User(username, password, "USER"));
    }

    public List<com.example.demo.model.User> getUserList() {
        return Constant.users;
    }
}


