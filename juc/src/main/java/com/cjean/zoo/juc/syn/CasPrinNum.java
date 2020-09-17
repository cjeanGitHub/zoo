package com.cjean.zoo.juc.syn;

import java.util.concurrent.TimeUnit;

public class CasPrinNum {

    enum READYTORUN{T1,T2}

    static volatile READYTORUN r = READYTORUN.T1;

    public static void main(String[] args) {

        //NGINX 线程数是核心数的2倍，建议java中多线程中的线程数是核心数+1 cache fix single schedule
        //定时器框架 quarz
        System.out.println("开始...");

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();


        new Thread(()->{

            for (int i = 0; i < 7; i++) {
                while (r!= READYTORUN.T1) {

                }
                System.out.println(aI[i]);
                r = READYTORUN.T2;
            }

        },"t1").start();
        new Thread(()->{

            for (int i = 0; i < 7; i++) {
                while (r!= READYTORUN.T2) {

                }
                System.out.println(aC[i]);
                r = READYTORUN.T1;
            }

        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束...");


    }



}
