package com.vyshnavi.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Expecting Heavy Traffic";
    }

    public String getFortuneWithException() {
        throw new RuntimeException("Accident Occured! Highway closed");
    }
}
