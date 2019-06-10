package com.example.demo.controller;

import com.example.demo.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoodsController {

    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/single/{id}")
    public String single() {
        return "single";
    }

    @RequestMapping("/category")
    public String category() {
        return "category";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String n, Model model) {
        model.addAttribute("n", n);
        model.addAttribute("goods", Constant.goods);
        return "search";
    }
}
