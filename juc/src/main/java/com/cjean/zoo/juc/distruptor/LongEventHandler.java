/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LongEventHandler
 * Author:   14172
 * Date:     2020/6/16 21:25
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.zoo.juc.distruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author 14172
 * @create 2020/6/16
 * @since 1.0.0
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    public volatile static int count = 0;

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        count++;
//        longEvent.setEvnet(8888L);
//        longEvent.setEvnet(l);

        System.out.println(longEvent.getEvnet());
        System.out.println("123");
    }
}
