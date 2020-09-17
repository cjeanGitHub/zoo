/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LongEvent
 * Author:   14172
 * Date:     2020/6/16 21:23
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.zoo.juc.distruptor;

/**
 * @author 14172
 * @create 2020/6/16
 * @since 1.0.0
 */
public class LongEvent {
    Long evnet;

    public Long getEvnet() {
        return evnet;
    }

    public void setEvnet(Long evnet) {
        this.evnet = evnet;
    }
    @Override
    public String toString() {
        return "LongEvent{" +
                "evnet=" + evnet +
                '}';
    }
}
