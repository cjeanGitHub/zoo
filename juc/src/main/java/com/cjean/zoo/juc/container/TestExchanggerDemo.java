package com.cjean.zoo.juc.container;

import lombok.SneakyThrows;

import java.util.concurrent.Exchanger;

public class TestExchanggerDemo {
    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();
        ExchangerTest t1 = new ExchangerTest(stringExchanger, "hello anyone ,i m T1", "T1");
        ExchangerTest t2 = new ExchangerTest(stringExchanger, "hello anyone ,i m T2", "T2");
        t1.start();
        t2.start();

    }
    static class ExchangerTest extends Thread{
        private Exchanger exchanger;
        private String msg;
        private String tName;

        public ExchangerTest(Exchanger exchanger, String msg, String tName) {
            this.exchanger = exchanger;
            this.msg = msg;
            this.tName = tName;
        }

        @SneakyThrows
        public void run(){
            System.out.println(this.tName+":交换，"+exchanger.exchange(msg));
        }
    }
}
