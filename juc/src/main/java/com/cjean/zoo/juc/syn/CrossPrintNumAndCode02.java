package com.cjean.zoo.juc.syn;

/**
 * 打印 A1B2C3...Z26
 * <p>
 * A:65 z:90 a:97 z:122
 */

public class CrossPrintNumAndCode02 {

    public static void main(String[] args) {
        final String lock1 = new String("lock1");
        final String lock2 = new String("lock2");

//        for (int i = 0; i < 1000; i++) {
//            if ("A".equalsIgnoreCase(String.valueOf((char) i))) {
//                System.out.println(i);
//                System.out.println((char) i);
//            }
//        }
//        System.out.println((char) (122));


        // 打印字母
        new Thread(() -> {
            synchronized (lock1) {
                for (int i = 65; i < 91; i++) {
                    lock1.notify();
                    System.out.print((char) i);
                    try {
                        lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                lock1.notify();

            }

        }, "t1").start();


        //打印数字
        new Thread(() -> {
            synchronized (lock1) {

                for (int i = 1; i < 27; i++) {
                    System.out.print(i);
                    lock1.notify();
                    try {
                        lock1.wait();
//                        if (i != 26) lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, "t2").start();


    }

    public void printNun() {

    }
}
