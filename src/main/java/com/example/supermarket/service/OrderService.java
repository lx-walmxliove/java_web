package com.example.supermarket.service;

import com.example.supermarket.pojo.entity.Order;
import com.example.supermarket.pojo.entity.OrderInfo;

import java.util.List;

public interface OrderService {
    Order selectorder(int id);
    List<Order> selectorderList();
    public OrderInfo orderInfo(Order order);
}
