package com.example.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.supermarket.dao.MarketDao;
import com.example.supermarket.dao.ShopCarDao;
import com.example.supermarket.pojo.dto.ResponseDTO;
import com.example.supermarket.pojo.entity.Market;
import com.example.supermarket.pojo.entity.ShopCar;
import com.example.supermarket.service.MarketService;
import com.example.supermarket.service.ShopCarService;
import com.example.supermarket.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ShopCarServiceImpl  extends BaseUtil implements ShopCarService {
    @Autowired
    ShopCarDao shopCarDao;
    @Autowired
    MarketDao marketDao;

    @Override
    public ResponseDTO edit(ShopCar shopCar) {
        QueryWrapper<ShopCar> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",shopCar.getUserId()).eq("market_id",shopCar.getMarketId());
        ShopCar shopCardb = shopCarDao.selectOne(wrapper);
        if(shopCardb == null){
            shopCarDao.insert(shopCar);
        }else{
            UpdateWrapper<ShopCar> updateWrapper = new UpdateWrapper<>();
            updateWrapper.set("count",shopCardb.getCount()+shopCar.getCount()).eq("user_id",shopCar.getUserId()).eq("market_id",shopCar.getMarketId());
            shopCarDao.update(null,updateWrapper);
        }
        HttpSession session = getSession();
        QueryWrapper<ShopCar> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("user_id",getUserId());
        session.setAttribute("shopcarcount",shopCarDao.selectCount(wrapper2));
        return ResponseDTO.ok("操作成功");
    }

    @Override
    public Long countshopcar(int id) {
        QueryWrapper<ShopCar> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",id);
        return  shopCarDao.selectCount(wrapper);
    }

    @Override
    public List<ShopCar> AllQueryShopCar() {
        QueryWrapper<ShopCar> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",getUserId());
        List<ShopCar> shopCars = shopCarDao.selectList(wrapper);
        for(ShopCar s : shopCars){
            QueryWrapper<Market> wrapper2 = new QueryWrapper<>();
            wrapper2.eq("marker_id",s.getMarketId());
            s.setMarket(marketDao.selectOne(wrapper2));
        }
        return shopCars;
    }
}
