package com.example.supermarket.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * market_type
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketType implements Serializable {
    @TableField(exist = false)
    private List<MarketType> sonMarketTypes;

    @TableId(type = IdType.AUTO)
    private Integer marketTypeId;

    /**
     * 父类型的id
     */
    private Integer parentTypeId;

    private String typeName;

    /**
     * 排序优先展示
     */
    private Integer sort;

    private String iconClass;

    private static final long serialVersionUID = 1L;


}