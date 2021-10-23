package com.example.supermarket.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * market
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("market")
public class Market implements Serializable{
    /**
     * 商品id
     */
    @TableId(type = IdType.AUTO)
    private Integer markerId;

    /**
     * 商品标题
     */
    private String markerTitle;

    /**
     * 商品图片
     */
    private String marketImg;

    /**
     * 商品类型id
     */
    private Integer marketTypeId;

    /**
     * 商品进货价格
     */
    private Double marketOldPrice;

    /**
     * 商品当前价格
     */
    private Double marketPrice;

    /**
     * 是不是正在销售
     */
    private String marketOnSale;

    /**
     * 商品详情
     */
    private String markerDetail;

    /**
     * 库存
     */
    private Integer marketCount;

    /**
     * 商家名字
     */
    private String marketMerchartName;

    private Integer marketEvaluationCount;

    private static final long serialVersionUID = 1L;
}