package com.cjean.zoo.juc.distruptor;


import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestDistruptor {
    public static void main(String[] args) {

        long beginTime = System.currentTimeMillis();

        //由于是多线程，一个生产者p1,多个消费者（consumer/event），c1/c2,c3
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        //创建程序计数器countdownlanch，
        CountDownLatch countDownLatch = new CountDownLatch(1);
        //
        //创建缓存环的大小 2的min次数
        int buffSize = 1024;
        //创建分离器
        Disruptor<InParkingDataEven> disruptor = new Disruptor<InParkingDataEven>(new EventFactory() {
            @Override
            public Object newInstance() {
                return new InParkingDataEven();
            }
        }, buffSize, executorService, ProducerType.SINGLE, new YieldingWaitStrategy());
        //创建使用分离器创建消费者
        EventHandlerGroup<InParkingDataEven> group =
                disruptor.handleEventsWith(new ParkingDataInDbHandler(), new ParkingDataInKafkaHandler());
        group.then(new ParkingDataJMSHandler());
        //消费者启动等待 生产者提供服务
        disruptor.start();
        //生产者生产
        executorService.submit(new InParkingDataEventPublisher(disruptor, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //消费完服务，分离器停止
        disruptor.shutdown();
        //线程池停止
        executorService.shutdown();
        System.out.println("总耗时:" + (System.currentTimeMillis() - beginTime));

    }
}

//1.创建事件
class InParkingDataEven {
    private String carlicence = "";

    public String getCarlicence() {
        return carlicence;
    }

    public void setCarlicence(String carlicence) {
        this.carlicence = carlicence;
    }
}

// 2.创建针对事件的处理的具体实现
class ParkingDataInDbHandler implements EventHandler<InParkingDataEven>, WorkHandler<InParkingDataEven> {

    @Override
    public void onEvent(InParkingDataEven event, long sequence, boolean endOfBatch) throws Exception {
        this.onEvent(event);

    }

    @Override
    public void onEvent(InParkingDataEven event) throws Exception {
        String name = Thread.currentThread().getName();
        String carLicense = event.getCarlicence();
        System.out.println(String.format("Thread Id %s send %s in plaza messsage to DB...", name, carLicense));

    }
}

class ParkingDataInKafkaHandler implements EventHandler<InParkingDataEven> {

    @Override
    public void onEvent(InParkingDataEven event, long sequence, boolean endOfBatch) throws Exception {
        String name = Thread.currentThread().getName();
        String carLicense = event.getCarlicence();

        System.out.println(String.format("Thread Id %s send %s in plaza messsage to kafka...", name, carLicense));

    }

}

class ParkingDataJMSHandler implements EventHandler<InParkingDataEven> {

    @Override
    public void onEvent(InParkingDataEven event, long sequence, boolean endOfBatch) throws Exception {
        String name = Thread.currentThread().getName();
        String carLicense = event.getCarlicence();

        System.out.println(String.format("Thread Id %s send %s in plaza messsage to JMS...", name, carLicense));

    }

}

// 3.创建测试实验对象并将对象放入分离器中
class InParkingDataEventPublisher implements Runnable {
    Disruptor<InParkingDataEven> disruptor;
    private CountDownLatch countDownLatch;
    private static int LOOP = 10;

    public InParkingDataEventPublisher(Disruptor<InParkingDataEven> disruptor, CountDownLatch countDownLatch) {
        this.disruptor = disruptor;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        InParkingDataEventTranslator inParkingDataEventTranslator = new InParkingDataEventTranslator();

        for (int i = 0; i < LOOP; i++) {
            disruptor.publishEvent(inParkingDataEventTranslator);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        countDownLatch.countDown();
        System.out.println("生产者写完" + LOOP + "个消息");
    }

    class InParkingDataEventTranslator implements EventTranslator<InParkingDataEven> {
        @Override
        public void translateTo(InParkingDataEven event, long sequence) {
            this.generateInParingDataEvent();
        }

        private InParkingDataEven generateInParingDataEvent() {
            InParkingDataEven inParkingDataEven = new InParkingDataEven();
            int cardLicence = (int) Math.random() * 8000;
            cardLicence += 1000;
            inParkingDataEven.setCarlicence("京Z" + cardLicence);
            System.out.println("Thread Id " + Thread.currentThread().getId() + " 写完一个event");
            return inParkingDataEven;
        }
    }
}



