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
import com.lmax.disruptor.util.DaemonThreadFactory;

/**
 * @author 14172
 * @create 2020/6/16
 * @since 1.0.0
 * disruptor为了迎合lanmbda 进行改写分离方式
 */
public class Main3 {
    public static void main(String[] args) {
        int bufferSize = 1024;
        Disruptor<LongEvent> longEventDisruptor = new Disruptor<>(LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);
        longEventDisruptor.handleEventsWith((longEvent, l, b)->{
            System.out.println("lambda,,,");
            System.out.println(longEvent.getEvnet());
        });
        longEventDisruptor.start();

        RingBuffer<LongEvent> ringBuffer = longEventDisruptor.getRingBuffer();

        ringBuffer.publishEvent((event, sequence) -> event.setEvnet(222L));

        ringBuffer.publishEvent((event, sequence, arg0) -> event.setEvnet(arg0),1111L);

    }
}
