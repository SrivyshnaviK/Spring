package com.spring;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{
    private final FortuneService fortuneService;
    @Value("${vyshnavi.email}")
    private String email;
    @Value("${vyshnavi.name}")
    private String name;
    public String getName(){
        return name;
    }
    public String getEmail() {
        return email;
    }
    public SwimCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Swim for 30min a day";
    }
    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
