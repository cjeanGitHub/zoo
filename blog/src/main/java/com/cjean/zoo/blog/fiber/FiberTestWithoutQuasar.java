package com.cjean.zoo.blog.fiber;//package com.cjean.exercise.exercise01.blogtestdemo.fiber;
//
//public class FiberTestWithoutQuasar {
//    public static void main(String[] args) throws Exception{
//
//        long start = System.currentTimeMillis();
//
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                calc();
//            }
//        };
//        int size = 10000;
//        Thread[] threads = new Thread[size];
//
//        for (int i = 0; i < threads.length; i++) {
//            threads[i] = new Thread(r);
//        }
//        for (int i = 0; i < threads.length; i++) {
//            threads[i].start();
//        }
//        for (int i = 0; i < threads.length; i++) {
//            threads[i].join();
//        }
//
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);
//
//    }
//    static void calc(){
//        int result = 0;
//        for (int i = 0; i < 10000; i++) {
//            for (int j = 0; j < 200; j++) result += j;
//        }
//    }
//}
