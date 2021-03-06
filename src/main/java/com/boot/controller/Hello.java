package com.boot.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Hello {

    @Async
    public void sayHello(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("业务进行中....");
    }
    @Scheduled(cron = "0/2 * * * * ?")
    public void hello(){
        System.out.println("hello.....");
    }
}
