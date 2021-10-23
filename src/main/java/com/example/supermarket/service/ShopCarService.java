package com.example.supermarket.service;

import com.example.supermarket.pojo.dto.ResponseDTO;
import com.example.supermarket.pojo.entity.ShopCar;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ShopCarService {
    //购物车增加和更改
    public ResponseDTO edit(ShopCar shopCar);
    //购物车数量
    public Long countshopcar(int id);
    //全部购物车信息
    List<ShopCar> AllQueryShopCar();
}
