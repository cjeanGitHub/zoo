package com.cjean.zoo.juc.syn;

import java.util.ArrayList;
import java.util.List;


public class TestWaitNotifyDemo05 {
    /**
     * 增加 volatile，估计是时间片的问题，两个线程并不是同时间启动，如果t2线程在5之后启动就不会停止
     *             也不行
     */
    static List<Object> objects = new ArrayList<>();
    static volatile int size = 0;
    public static void main(String[] args) {
//        System.out.println(objects.size());

        new Thread(() -> {
            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {

                objects.add(new Object());
                size++;
                System.out.println("add: " + objects.size());


            }
            System.out.println("t1停止");

        }, "t1").start();

        new Thread(() -> {
            System.out.println("t2启动");
            while (true) if (5 == size) break;
            System.out.println("t2停止");
        }, "t2").start();
    }
}
