package com.cjean.zoo.base.breakdemo;

public class BreakDemo04 {
    public static void main(String[] args) {

        OUT1:
        for (int i = 0; i < 5; i++) {
            if (2==i) break OUT1;
        }

    }

}
