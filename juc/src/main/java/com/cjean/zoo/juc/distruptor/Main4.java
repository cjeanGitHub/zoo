/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Main1
 * Author:   14172
 * Date:     2020/6/16 21:28
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.zoo.juc.distruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.*;

/**
 * @author 14172
 * @create 2020/6/16
 * @since 1.0.0
 * disruptor为了迎合lanmbda 进行改写分离方式
 */
public class Main4 {
    public static void main(String[] args) {

        long l1 = System.currentTimeMillis();

        int bufferSize = 1024;
//        Disruptor<LongEvent> longEventDisruptor = new Disruptor<>(LongEvent::new, bufferSize, Executors.defaultThreadFactory(),
//                ProducerType.SINGLE, new BlockingWaitStrategy());
        Disruptor<LongEvent> longEventDisruptor = new Disruptor<LongEvent>(LongEvent::new
                , bufferSize
                , Executors.defaultThreadFactory()
                , ProducerType.MULTI
                , new BlockingWaitStrategy());


//        longEventDisruptor.handleEventsWith((longEvent, l, b) -> {
//            System.out.println("lambda,,,");
//            System.out.println(longEvent.getEvnet());
//        });
        longEventDisruptor.handleEventsWith(new LongEventHandler());
        longEventDisruptor.start();

        final int threadCount = 50;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadCount; i++) {
            final int threadName = i;
            executorService.submit(() -> {
                try {
                    System.out.println("thread ready:" + threadName);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                for (int j = 0; j < 10; j++) {
                    System.out.println(threadName+"：thread,create:" + j);
                    longEventDisruptor.publishEvent(
                            (event, l) -> {
                                event.setEvnet(8899L);
                            }
                    );
                }

            });
        }
//        longEventDisruptor.shutdown();
        executorService.shutdown();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
        System.out.println(LongEventHandler.count);
        System.out.println("NanoTime:"+(System.currentTimeMillis()-l1));


    }
}
