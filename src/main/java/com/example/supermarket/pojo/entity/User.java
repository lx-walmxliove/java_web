package com.example.supermarket.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User implements Serializable{
    @TableId
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 真实名字
     */
    private String realName;

    private String phone;

    private String password;

    private Date lastLoginTime;

    /**
     * 最后登录ip
     */
    private String lastLoginIp;

    private static final long serialVersionUID = 1L;

}