package com.cjean.zoo.juc.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestWaitNotifyDemo10 {
    public static void main(String[] args) {
        /**
         * 由于会有cpu时间片等问题，导致2个线程在读取集合大小时并不一定时非常及时的
         */
        List<Object> objects = new ArrayList<>();
//        System.out.println(objects.size());
        final Object o1 = new Object();
        final Object o2 = new Object();
        final int[] size = {0};

        new Thread(() -> {
            System.out.println("t2启动");
            synchronized (o1) {
                if (4 != size[0]) {
                    try {
                        o1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            System.out.println("t2停止");
            synchronized (o2){
                o2.notify();

            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println("t1启动");
            synchronized (o1) {
                for (int i = 0; i < 10; i++) {
                    objects.add(new Object());
                    System.out.println("add: " + objects.size());
                    if (4 == (size[0] = i)) {

                        o1.notify();
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (o2) {

                            try {
                                o2.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                }
            }
            System.out.println("t1停止");

        }, "t1").start();

    }
}
