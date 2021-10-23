package com.example.supermarket.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.supermarket.pojo.entity.Market;
import com.example.supermarket.pojo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao extends BaseMapper<Order> {

}