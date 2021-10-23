package com.example.supermarket.service.pay;

import com.example.supermarket.pojo.entity.Order;
import com.example.supermarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class AilpayServiceImpl implements AilpayService {
    @Autowired
    OrderService orderService;

    @Override
    public Map<String, Object> nativePay(String marketName, String price) {
        Order order = orderService.selectorder(1);
        return null;
    }

    @Override
    public Map<String, Object> mobilePay(String marketName, String price) {
        return null;
    }
}
