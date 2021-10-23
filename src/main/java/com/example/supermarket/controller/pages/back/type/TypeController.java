package com.example.supermarket.controller.pages.back.type;

import com.example.supermarket.pojo.dto.ResponseDTO;
import com.example.supermarket.pojo.entity.MarketType;
import com.example.supermarket.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TypeController {

    @Autowired
    private MarketService marketService;

    @RequestMapping("/addtypemarket")
    public String addtypemarket(Model model){
        model.addAttribute("types",marketService.selectParentTypeById(-1));
        return "pages/back/type/addtypemarket";
    }

    /**
     * 添加商品
     * @param marketType
     * @return
     */
    @RequestMapping("/addType")
    @ResponseBody
    ResponseDTO addMarketdata(MarketType marketType){
        return marketService.addTypeMarket(marketType);
    }

}
