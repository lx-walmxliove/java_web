package com.example.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.supermarket.dao.MarketDao;
import com.example.supermarket.dao.MarketTypeDao;
import com.example.supermarket.pojo.dto.ResponseDTO;
import com.example.supermarket.pojo.entity.Market;
import com.example.supermarket.pojo.entity.MarketType;
import com.example.supermarket.service.MarketService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MarketServiceImpl implements MarketService {
    @Autowired
    private MarketDao marketDao;
    @Autowired
    private MarketTypeDao marketTypeDao;

    @Override
    public Map<String, Object> addMarket(Market market) {
        Map<String,Object> mapMarket = new HashMap<>();
        int insert = marketDao.insert(market);
        if(insert > 0){
            mapMarket.put("res",true);
            mapMarket.put("msg","添加成功");
        }else{
            mapMarket.put("res",false);
            mapMarket.put("msg","添加失败");
        }
        return mapMarket;
    }

    @Override
    public ResponseDTO selectMarketById(int i) {
        QueryWrapper<Market> wrapper = new QueryWrapper<>();
        wrapper.eq("market_type_id",i);
        List<Market> markets = marketDao.selectList(wrapper);
        if(markets != null){
            return ResponseDTO.ok("查询成功！",markets);
        }else{
            return ResponseDTO.fail("查询失败！");
        }
    }

    @Override
    public Market queryMarketOneById(int i) {
        QueryWrapper<Market> wrapper = new QueryWrapper<>();
        wrapper.eq("marker_id",i);
        return marketDao.selectOne(wrapper);
    }

    @Override
    public ResponseDTO addTypeMarket(MarketType marketType) {
        int insert = marketTypeDao.insert(marketType);
        if(insert > 0){
            return ResponseDTO.ok("添加成功！");
        }else{
            return ResponseDTO.fail("添加失败！");
        }
    }

    @Override
    public List<MarketType> selectParentTypeById(int i) {
        QueryWrapper<MarketType> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_type_id",i).or();
        List<MarketType> marketTypeVOS = marketTypeDao.selectList(wrapper);
        for(MarketType g:marketTypeVOS){
            QueryWrapper<MarketType> wrappers = new QueryWrapper<>();
            i = g.getMarketTypeId();
            wrappers.eq("parent_type_id",i);
            g.setSonMarketTypes(marketTypeDao.selectList(wrappers));
        }

        return marketTypeVOS;
    }
}
