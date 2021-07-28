package com.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisSetterCoach implements Coach {
    @Autowired
    @Qualifier("randomFortuneService")
    public FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "Play 2hrs Tennis";
    }
    /*@Autowired
    public void crazyService(FortuneService fortuneService){
        System.out.println("Setter crazy Method");
        this.fortuneService=fortuneService;
    }*/
    public TennisSetterCoach(){
        System.out.println("Default TennisSetter Constructor");
    }
    @Override
    public String getDailyFortune(){
        return fortuneService.getFortune();
    }

}
