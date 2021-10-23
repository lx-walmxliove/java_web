package com.example.supermarket.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.supermarket.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDao extends BaseMapper<User> {

}