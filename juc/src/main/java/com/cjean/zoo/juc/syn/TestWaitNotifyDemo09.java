package com.cjean.zoo.juc.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestWaitNotifyDemo09 {
    static volatile List<Object> objects = new ArrayList<>();
    private static final Object o1 = new Object();//锁

    public static void main(String[] args) {
        /**
         * 由于会有cpu时间片等问题，导致2个线程在读取集合大小时并不一定时非常及时的
         */

//        System.out.println(objects.size());
//        final Object o1 = new Object();
//        Object o2 = new Object();
//        int[] size = {0};

        new Thread(() -> {
            System.out.println("t2启动");
            synchronized (o1) {
                if (4 != objects.size()) {
                    try {
                        System.out.println("t2启动..pre .wait");
                        o1.wait();
                        System.out.println("t2启动...wait");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2停止");
        }, "t2").start();

        new Thread(() -> {
            System.out.println("t1启动");
            synchronized (o1) {
                for (int i = 0; i < 10; i++) {
                    objects.add(new Object());
                    System.out.println("add: " + objects.size());
                    if (4 == i) {
                        // 增加这个睡眠 解决 当 size = 5时，也解除了wait状态，
                        // 但是t1继续追加元素，导致在t2线程中 if size始终不是4，再次wait的窘境
//                        try {
//                            TimeUnit.SECONDS.sleep(1);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        o1.notify();

                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }
            System.out.println("t1停止");

        }, "t1").start();

    }
}
