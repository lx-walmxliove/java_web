package com.example.supermarket.controller;

import com.example.supermarket.dao.UserDao;
import com.example.supermarket.pojo.entity.MarketType;
import com.example.supermarket.pojo.entity.User;
import com.example.supermarket.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private MarketService marketService;

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        User user = userDao.selectById(1);
        return "Hello SpringBoot!!";
    }

    @RequestMapping("/index")
    public String indexs(Model model){
        List<MarketType> marketTypes = marketService.selectParentTypeById(-1);
        model.addAttribute("types",marketTypes);
        return "index";
    }

    @RequestMapping("/indexdata")
    @ResponseBody
    public Map<Object,Object> indexdata(Integer i){
        HashMap<Object, Object> map = new HashMap<>();
        if(i != null){
            List<MarketType> marketTypes = marketService.selectParentTypeById(-1);
            for(MarketType t:marketTypes){
                if(t.getSonMarketTypes() != null && t.getMarketTypeId() == i){
                    map.put("datas",t);
                }
            }
        }else{
            map.put("datas",false);
        }
        return map;
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/login")
    public String login(){
        return "pages/front/index";
    }



}
