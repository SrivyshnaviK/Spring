package com.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaValueDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);
        SwimCoach coach= (SwimCoach) context.getBean("swimCoach",Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getEmail());
        System.out.println(coach.getName());
    }
}
