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

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 14172
 * @create 2020/6/16
 * @since 1.0.0
 */
public class Main1 {
    public static void main(String[] args) {
        int bufferSize = 1024;

        LongEventFactory longEventFactory = new LongEventFactory();

        Disruptor<LongEvent> longEventDisruptor = new Disruptor<LongEvent>(longEventFactory, bufferSize, Executors.defaultThreadFactory());
        longEventDisruptor.handleEventsWith(new LongEventHandler());

        longEventDisruptor.start();

        RingBuffer<LongEvent> ringBuffer = longEventDisruptor.getRingBuffer();
        long next = ringBuffer.next();
        try {
            LongEvent longEvent = ringBuffer.get(next);
            longEvent.setEvnet(9999L);
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            ringBuffer.publish(next);
        }
//        longEventDisruptor.shutdown();// 会有还没消费 main线程就把分离器关闭的情况出现
    }
}
