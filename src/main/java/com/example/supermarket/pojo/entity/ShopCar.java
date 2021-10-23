package com.example.supermarket.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * shop_car
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopCar implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer shopCarId;

    private Integer userId;

    private Integer marketId;
    /**
     * 当个物品类型的物品数
     */
    private Integer count;

    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private Market market;

}