package com.example.demo.controller;

import com.example.demo.Constant;
import com.example.demo.model.Good;
import com.example.demo.service.GoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GoodsController {

    private final GoodService goodService;

    public GoodsController(GoodService goodService) {
        this.goodService = goodService;
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public String doAdd(HttpServletRequest request,
                        @RequestParam("name") String name,
                        @RequestParam("category") String category,
                        @RequestParam("stock") int stock,
                        @RequestParam("price") int price,
                        @RequestParam("description") String description) {
        Cookie cookie = WebUtils.getCookie(request, "username");
        String username = cookie.getValue();

        goodService.newGood(name, stock, price, category, description, username);

        return "redirect:/home";
    }

    @GetMapping("/single/{id}")
    public String single(@PathVariable int id, Model model) {
        model.addAttribute("good", Constant.goods.get(id));
        return "single";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("good", Constant.goods.get(id));
        goodService.removeGood(id);
        return "redirect:/home";
    }

    @PostMapping("/single/{id}")
    public String updateSingle(HttpServletRequest request,
                               @PathVariable int id,
                               @RequestParam("name") String name,
                               @RequestParam("category") String category,
                               @RequestParam("stock") int stock,
                               @RequestParam("price") int price,
                               @RequestParam("description") String description) {
        Cookie cookie = WebUtils.getCookie(request, "username");
        String username = cookie.getValue();


        Constant.goods.set(id, new Good(id, name, stock, price, category, description, username));
        return "redirect:/home";
    }

    @RequestMapping("/category")
    public String category() {
        return "category";
    }

    @RequestMapping("/search")
    public String search(HttpServletRequest request, @RequestParam String n, Model model) {
        Cookie cookie = WebUtils.getCookie(request, "username");
        String username = cookie.getValue();
        List<Good> goods = goodService.getGoods(username);
        model.addAttribute("n", n);
        model.addAttribute("goods", goods);
        return "search";
    }
}
