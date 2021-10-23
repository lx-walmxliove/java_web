package com.example.supermarket.service;

import com.example.supermarket.pojo.dto.ResponseDTO;
import com.example.supermarket.pojo.entity.Market;
import com.example.supermarket.pojo.entity.MarketType;

import java.util.List;
import java.util.Map;


public interface MarketService {
    //添加商品
    Map<String,Object> addMarket(Market market);

    //查商品
    ResponseDTO selectMarketById(int i);

    //查一个商品
    Market queryMarketOneById(int i);

    //添加商品类型
    ResponseDTO addTypeMarket(MarketType marketType);

    //查类型
    List<MarketType> selectParentTypeById(int i);
}
