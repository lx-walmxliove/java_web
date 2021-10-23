package com.example.supermarket.controller.pages.front;

import com.example.supermarket.dao.MarketDao;
import com.example.supermarket.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MarketFrontController {
    @Autowired
    MarketService marketService;

    @RequestMapping("/marketdetil/{id}")
    public String marketdetil(@PathVariable int id, Model model){
        model.addAttribute("markets",marketService.queryMarketOneById(id));
        return "pages/front/marketdetil";
    }
}
