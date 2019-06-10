package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    private List<List<String>> userList;


    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
