package com.example.demo.controller;

import com.example.demo.model.Good;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             HttpSession session) {

        userService.addUser(username, password);

        return "redirect:/login";
    }

    @PostMapping("login")
    public String postLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session) {

        if ("admin".equals(username) && "123456".equals(password)) {
            session.setAttribute("user", username);
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/user-list")
    public String userList(Model model) {
        List<User> users = userService.getUserList();
        model.addAttribute("users", users);
        return "user-list";
    }
}
