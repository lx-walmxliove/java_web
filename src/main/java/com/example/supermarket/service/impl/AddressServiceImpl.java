package com.example.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.supermarket.dao.AddressDao;
import com.example.supermarket.pojo.entity.Address;
import com.example.supermarket.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;

    @Override
    public Address queryAddress(int id) {
        QueryWrapper<Address> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",id);
        return addressDao.selectOne(wrapper);
    }
}
