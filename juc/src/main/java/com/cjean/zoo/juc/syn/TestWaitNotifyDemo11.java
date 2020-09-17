package com.cjean.zoo.juc.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;


public class TestWaitNotifyDemo11 {

    public static void main(String[] args) {
        /**
         * 由于会有cpu时间片等问题，导致2个线程在读取集合大小时并不一定时非常及时的
         */
        List<Object> objects = new ArrayList<>();
//        System.out.println(objects.size());

        Thread t2 = new Thread(() -> {
            System.out.println("t2启动");
            if (5 != objects.size()) {
                LockSupport.park();
            }

            System.out.println("t2停止");
        }, "t2");
        t2.start();

        new Thread(() -> {
            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {

                objects.add(new Object());
                System.out.println("add: " + objects.size());
                if (5==objects.size()) {
                    LockSupport.unpark(t2);
                }
            }
            System.out.println("t1停止");

        }, "t1").start();


    }
}
