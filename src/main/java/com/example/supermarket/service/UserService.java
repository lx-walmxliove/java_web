package com.example.supermarket.service;


import com.example.supermarket.pojo.entity.User;

public interface UserService {
    User login(String username,String password);

}
