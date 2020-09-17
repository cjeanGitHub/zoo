package com.cjean.zoo.applications.service;

import com.cjean.exercise.exercise01.controller.MyWebSocketController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
//是否开启定位任务
//@EnableScheduling
public class TimeTask {
    private static Logger logger = LoggerFactory.getLogger(TimeTask.class);

    @Scheduled(cron = "0/1 * * * * ?")   //每分钟执行一次  0 0/1 * * * ?
    public void test() {
        System.err.println("*********   定时任务执行   **************");
        CopyOnWriteArraySet<MyWebSocketController> webSocketSet =
                MyWebSocketController.getWebSocketSet();
        int i = 0;
        webSocketSet.forEach(c -> {
            try {
                c.sendMessage("  定时发送  " + new Date().toLocaleString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.err.println("/n 定时任务完成.......");
    }

}