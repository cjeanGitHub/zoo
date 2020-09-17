package com.cjean.zoo.juc.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestWaitNotifyDemo04 {
    /**
     * 增加 volatile
     *  也不行，volatile是监视的值的变化，并不会对成员属性进行动态监视
     *  增加 睡眠时间就可以（睡眠时间解决了cpu分配线程运行时间的问题）
     */
    static volatile List<Object> objects = new ArrayList<>();
    public static void main(String[] args) {
//        System.out.println(objects.size());

        new Thread(() -> {
            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {

                objects.add(new Object());
                System.out.println("add: " + objects.size());
                //加1秒的睡眠时间，给t2线程在 5 之前启动的机会（被cpu分配时间片）
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1停止");

        }, "t1").start();

        new Thread(() -> {
            System.out.println("t2启动");
            while (true) if (5 == objects.size()) break;
            System.out.println("t2停止");
        }, "t2").start();
    }
}
