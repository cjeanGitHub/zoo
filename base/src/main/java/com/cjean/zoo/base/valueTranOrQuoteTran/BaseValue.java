package com.cjean.zoo.base.valueTranOrQuoteTran;

public class BaseValue {
    public static void main(String[] args) {

        int val = 9;
        incr(val);
        System.out.println(val);

        System.out.println("--------------基本数据-------------");
    }

    public static void incr(int val) {
        val++;
        System.out.println("incr value:" + val);
    }
}
