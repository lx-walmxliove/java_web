package com.example.supermarket.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.supermarket.pojo.entity.Market;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MarketDao extends BaseMapper<Market> {

}