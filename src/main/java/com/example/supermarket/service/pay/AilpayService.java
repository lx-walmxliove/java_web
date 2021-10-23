package com.example.supermarket.service.pay;

import java.util.Map;

/**
 * 实现支付宝支付，需要调用阿里的接口，以及拿到秘钥或者密文，需要对支付宝进行签约获取
 */
public interface AilpayService {
    //支付宝扫描支付
    public Map<String,Object> nativePay(String marketName,String price);

    //支付宝H5支付
    public Map<String,Object> mobilePay(String marketName,String price);

}
