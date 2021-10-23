package com.example.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.supermarket.dao.OrderDao;
import com.example.supermarket.pojo.entity.Order;
import com.example.supermarket.pojo.entity.OrderInfo;
import com.example.supermarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public Order selectorder(int id) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",id);
        return orderDao.selectOne(wrapper);
    }

    @Override
    public List<Order> selectorderList() {
        return orderDao.selectList(null);
    }

    @Override
    public OrderInfo orderInfo(Order order) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(order.getOrderId());
        orderInfo.setOldPrice(order.getActualPayment());
        return orderInfo;
    }
}
