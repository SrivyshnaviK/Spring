package com.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-ApplicationContext.xml");
        Coach coach1=context.getBean("myCoach",Coach.class);
        Coach coach2=context.getBean("myCoach",Coach.class);
        System.out.println("Result for equality:"+(coach1==coach2));
        System.out.println(coach1);
        System.out.println(coach2);
    }
}

