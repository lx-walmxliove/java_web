package com.example.supermarket.util;

public class MathUtil {
    //保留几位小数
    public static Double round(Double oldNum, int FF) {
        return Math.round(oldNum * Math.pow(10, FF)) / Math.pow(10, FF);
    }
}
