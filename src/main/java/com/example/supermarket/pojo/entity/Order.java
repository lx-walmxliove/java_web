package com.example.supermarket.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * order
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("order")
public class Order implements Serializable {
    /**
     * 订单id
     */
    @TableId
    private String orderId;

    private Integer userId;

    /**
     * 总金额
     */
    private Double allCost;

    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 收货人电话
     */
    private String receiverPhone;

    /**
     * 收货人名字
     */
    private String receiverName;

    /**
     * 收货人地址
     */
    private String receiverAddress;

    /**
     * 支付类型
     */
    private String payType;

    /**
     * 付款状态
     */
    private String status;

    /**
     * 实际付款金额
     */
    private Double actualPayment;

    /**
     * 总减免
     */
    private Double totalDeduction;

    private static final long serialVersionUID = 1L;


}