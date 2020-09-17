package com.cjean.zoo.blog.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest {

    public static void main(String[] args) {
        test1_7DeadLoop();
    }

    private static void test1_7DeadLoop(){
        /**
         * https://www.cnblogs.com/developer_chan/p/10450908.html
         * 1.7中由于transfer转换过程中造成死循环和数据丢失的问题
         * 分析：在多线程中由于全局变量的共享和cpu时间片的原因导致多线程时
         * （a线程，b线程，a线程先执行，执行过程中挂起，b线程后执行，并执行完成）
         * 全局变量的修改导致transfer函数中关于元素位置的倒置，致使死循环以及数据丢失问题
         */
        HashMapThread thread0 = new HashMapThread();
        HashMapThread thread1 = new HashMapThread();
        HashMapThread thread2 = new HashMapThread();
        HashMapThread thread3 = new HashMapThread();
        HashMapThread thread4 = new HashMapThread();
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}


class HashMapThread extends Thread {
    private static AtomicInteger ai = new AtomicInteger();
    private static Map<Integer, Integer> map = new HashMap<>();

    @Override
    public void run() {
        while (ai.get() < 1000000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }
}