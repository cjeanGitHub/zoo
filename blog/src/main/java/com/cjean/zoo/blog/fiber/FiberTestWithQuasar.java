package com.cjean.zoo.blog.fiber;//package com.cjean.exercise.exercise01.blogtestdemo.fiber;
//
//import co.paralleluniverse.fibers.Fiber;
//import co.paralleluniverse.fibers.SuspendExecution;
//import co.paralleluniverse.strands.SuspendableRunnable;
//
//public class FiberTestWithQuasar {
//    // 测试方式1： https://blog.csdn.net/a772304419/article/details/105896655
//    public static void main(String[] args) throws Exception{
//
//        long start = System.currentTimeMillis();
//
//        int size = 10000;
//        Fiber<Void>[] fibers = new Fiber[size];
//
//        for (int i = 0; i < fibers.length; i++) {
//
//            fibers[i] = new Fiber<>(new SuspendableRunnable() {
//                @Override
//                public void run() throws SuspendExecution, InterruptedException {
//                    calc();
//                }
//            });
//        }
//        for (int i = 0; i < fibers.length; i++) {
//            fibers[i].start();
//        }
//        for (int i = 0; i < fibers.length; i++) {
//            fibers[i].join();
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
