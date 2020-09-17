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

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executors;

/**
 * @author 14172
 * @create 2020/6/16
 * @since 1.0.0
 */
public class Main2 {
    public static void main(String[] args) {
        int bufferSize = 1024;
        LongEventFactory longEventFactory = new LongEventFactory();
        Disruptor<LongEvent> longEventDisruptor
                = new Disruptor<>(longEventFactory, bufferSize, Executors.defaultThreadFactory());

        LongEventHandler longEventHandler = new LongEventHandler();
        longEventDisruptor.handleEventsWith(longEventHandler);
        longEventDisruptor.start();

        RingBuffer<LongEvent> ringBuffer = longEventDisruptor.getRingBuffer();
        EventTranslator<LongEvent> eventTranslator = new EventTranslator<LongEvent>() {
            @Override
            public void translateTo(LongEvent event, long sequence) {
                event.setEvnet(777L);
            }
        };
        ringBuffer.publishEvent(eventTranslator);

        EventTranslatorOneArg<LongEvent, Long> eventTranslatorOneArg = new EventTranslatorOneArg<LongEvent, Long>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Long arg0) {
                event.setEvnet(arg0);
            }
        };
        ringBuffer.publishEvent(eventTranslatorOneArg, 6666L);

    }
}
