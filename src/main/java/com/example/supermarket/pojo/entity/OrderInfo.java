package com.example.supermarket.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * order_info
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo implements Serializable {
    /**
     * 订单详情id
     */
    @TableId
    private Integer orderInfoId;

    private String orderId;

    /**
     * 原来的商品链接
     */
    private Integer originMarketId;

    /**
     * 当时的价格
     */
    private BigDecimal price;

    /**
     * 当时的数量
     */
    private Integer count;

    /**
     * 商品下单的图片
     */
    private String img;

    /**
     * 下单时的原价
     */
    private Double oldPrice;

    private static final long serialVersionUID = 1L;

}