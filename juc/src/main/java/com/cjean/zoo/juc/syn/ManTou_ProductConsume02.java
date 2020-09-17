package com.cjean.zoo.juc.syn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 打印 A1B2C3...Z26
 * <p>
 * A:65 z:90 a:97 z:122
 */

public class ManTou_ProductConsume02 {

    public static volatile LinkedList<String> manTou = new LinkedList<>();
    private static Object lock = new Object();
    private static int count = 0;

    public static void main(String[] args) {

        String s = new String();
        ArrayList<Object> objects = new ArrayList<>();
        boolean add = objects.add("123");

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();



        new ProductWork().start();
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new ConsumeWork().start();


    }

    public static synchronized int put(String tName, int num) {



        String s = new String();
        manTou.push(tName + "：造了一个馒头");
        count++;
        System.out.println(tName + "：造了一个馒头");
        lock.notifyAll();
        return ++num;
    }

    public static synchronized int get(String tName, int num) {
        String pop = manTou.pop();
        count--;
        System.out.println(tName + "：拿走了一个馒头,:" + pop);
        return ++num;
    }

    /**
     * 2个正在造馒头的人
     */
    static class ProductWork extends Thread {

        private String name;

        public ProductWork() {
        }

        public ProductWork(String name) {
            this.name = name;
        }

        public void run() {

            for (int i = 0; i < 2; i++) {
                new Product("p" + "--:" + i).start();
                System.out.println("p" + "--:" + i + "：启动...");
            }
        }

    }

    /**
     * 十个正在吃馒头的人
     */
    static class ConsumeWork extends Thread {

        private String name;

        public ConsumeWork() {
        }

        public ConsumeWork(String name) {
            this.name = name;
        }

        public void run() {

            for (int i = 0; i < 10; i++) {
                new Consumen("c" + "--:" + i).start();
                System.out.println("c" + "--:" + i + "：启动...");
            }
            System.out.println("停止chi馒头");
        }

    }

    /**
     * 每个造馒头的人
     */
    static class Product extends Thread {
        private String tName;
        private int num = 0;

        public Product() {
        }

        public Product(String tName) {
            this.tName = tName;
        }

        public void run() {
//            manTou.add(tName+"：馒头");
            synchronized (lock) {

                while (count < 10) {
                    if (num > 4) break;
                    num = put(tName, num);
//                    System.out.println("-----："+num);
                }

                System.out.println(tName + ":停止zao馒头");
            }

        }

    }

    /**
     * 每个吃馒头的人
     */
    static class Consumen extends Thread {
        private String tName;
        private int num = 0;

        public Consumen() {
        }

        public Consumen(String tName) {
            this.tName = tName;
        }

        public void run() {
            synchronized (lock) {

                while (count > 0) {
                    if (num > 2) break;
                    if (manTou.size() < 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = get(tName, num);

                }

            }
        }

    }


}
