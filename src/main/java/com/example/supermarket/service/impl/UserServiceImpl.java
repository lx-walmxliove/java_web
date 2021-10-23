package com.example.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.supermarket.dao.UserDao;
import com.example.supermarket.pojo.entity.User;
import com.example.supermarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User login(String username, String password) {
        if("".equals(username) || username == null){
            return null;
        }else if("".equals(password) || password == null){
            return null;
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone",username).or().eq("username",username);
        queryWrapper.eq("password",password);
        return userDao.selectOne(queryWrapper);
    }


}
