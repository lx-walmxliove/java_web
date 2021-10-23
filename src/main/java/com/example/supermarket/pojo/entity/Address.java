package com.example.supermarket.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * adress
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("adress")
public class Address implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer addressId;

    private Integer userId;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 详细地址
     */
    private String detailAddress;

    private String phone;

    /**
     * 收货人
     */
    private String receiver;
    /**
     * 是否的默认
     */
    private String moren;

    /**
     * 地点类型
     */
    private String tag;

    private static final long serialVersionUID = 1L;

}