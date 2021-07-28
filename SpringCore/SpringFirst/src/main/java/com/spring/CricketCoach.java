package com.spring;

public class CricketCoach implements Coach{
    private FortuneService fortuneService;
    private String email,name;
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public void setFortuneService(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Batting...and Balling...";
    }
    @Override
    public String getDailyFortune() {
       return fortuneService.getFortune();
    }
}
