package com.example.demo.controller;

import com.example.demo.model.Good;
import com.example.demo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;


@Controller
public class IndexController {

    private final GoodService goodService;

    public IndexController(GoodService goodService) {
        this.goodService = goodService;
    }

    @RequestMapping("/home")
    public String index(HttpServletResponse response, Principal principal, Model model) {
        String username = principal.getName();
        List<Good> goods = goodService.getGoods(username);
        saveCookie("username", principal.getName(), response);
        model.addAttribute("goods", goods);
        model.addAttribute("username", username);
        return "index";
    }

    private void saveCookie(String cookieName, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(cookieName, value);
        //maxAge is one month: 30*24*60*60
        cookie.setMaxAge(2592000);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
