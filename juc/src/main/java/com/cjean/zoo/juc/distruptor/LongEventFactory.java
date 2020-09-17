/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LongEventFactory
 * Author:   14172
 * Date:     2020/6/16 21:24
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.zoo.juc.distruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author 14172
 * @create 2020/6/16
 * @since 1.0.0
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
