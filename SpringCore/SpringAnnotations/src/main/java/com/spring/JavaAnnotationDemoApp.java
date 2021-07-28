package com.spring;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaAnnotationDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);
        Coach coach=context.getBean("tennisCoach",Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        TennisSetterCoach tennisSetterCoach=(TennisSetterCoach)context.getBean("tennisSetterCoach",Coach.class);
        System.out.println(tennisSetterCoach.getDailyFortune());
        context.close();
    }
}
