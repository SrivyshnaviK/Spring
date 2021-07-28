package com.spring;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    private String[] data={"Luck1","Luck2","Luck3","Luck4"};
    public String getFortune(){
        int index=new Random().nextInt(4);
        return data[index];
    }
}