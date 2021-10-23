package com.example.supermarket.controller.pages.back.order;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.pojo.entity.Order;
import com.example.supermarket.pojo.entity.ShopCar;
import com.example.supermarket.service.AddressService;
import com.example.supermarket.util.BaseUtil;
import com.example.supermarket.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class OrderController extends BaseUtil {
    @Autowired
    AddressService addressService;

    @RequestMapping("/orerInfo")
    public String orderInfo(String orderInfoStr, Model model,Double allCost){
        //利用alibb的fastjson来把json转成list
        List<ShopCar> shopCars = JSON.parseArray(orderInfoStr, ShopCar.class);
        model.addAttribute("shops",shopCars);
        Double allRelief = allCost * Math.random() * 9 * 0.1; //暂时进行，随机减免，
        Double actuallyPaid = allCost - allRelief;
        model.addAttribute("allCost",allCost);
        model.addAttribute("actuallyPaid", MathUtil.round(actuallyPaid,2));
        model.addAttribute("allRelief",MathUtil.round(allRelief,2));
        model.addAttribute("address",addressService.queryAddress(getUserId()));
        return "/pages/back/order/addPre";
    }

    @RequestMapping("/orderpay")
    public String OrderPay(Order order){
        order.setStatus("待付款!");
        order.setCreateTime(new Date());
        order.setUserId(getUserId());
        order.setPayType("支付宝");

        System.out.println(order);
        return "/pages/back/order/orderpay";
    }
}
