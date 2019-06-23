package com.example.demo.service;

import com.example.demo.Constant;
import com.example.demo.model.Good;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodService {
    public List<Good> getGoods(String username) {
        List<Good> goods = new ArrayList<>();
        for (Good good : Constant.goods) {
            if (good == null) {
                continue;
            }
            if (username.equals("admin")) {
                goods.add(good);
            } else {
                if (good.getUsername().equals(username)) {
                    goods.add(good);
                }
            }

        }
        return goods;
    }

    public void removeGood(int id) {
        Constant.goods.set(id, null);
    }

    public void newGood(String name, int stock, int price, String category, String description, String username) {
        int id = Constant.goods.size();
        Constant.goods.add(new Good(id, name, stock, price, category, description, username));
    }
}
