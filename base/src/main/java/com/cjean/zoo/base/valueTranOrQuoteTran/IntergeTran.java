package com.cjean.zoo.base.valueTranOrQuoteTran;

public class IntergeTran {
    public static void main(String[] args) {

        Integer val = 9;
        incr01(val);
        System.out.println(val);

        System.out.println("--------------包装数据 在 Integer 返回内 -128 ~ 127 -------------");

        Integer valOut = 365;
        incr01(valOut);
        System.out.println(valOut);

        System.out.println("--------------包装数据 在 Integer 返回内 -128 ~ 127 -------------");
        System.out.println("*****************************************");
        Integer valO02 = new Integer(367);
        incr02(valO02);
        System.out.println(valO02);

        System.out.println("--------------包装数据 -------------");
    }

    public static void incr01(Integer val) {
        val++;
        System.out.println("incr01 value:" + val);
    }

    public static void incr02(Integer val) {
        val.valueOf(77);
        System.out.println("incr02 value:" + val);
    }
}
