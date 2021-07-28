package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach{
    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "Practice Tennis";
    }
    @PostConstruct
    public void init(){
        System.out.println("Init Method!!!");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Destroy Method!!!");
    }
    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
