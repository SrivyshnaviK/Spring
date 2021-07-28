package com.spring;

public class MyApp {
    public static void main(String[] args) {
        Coach coach;
        coach=new TrackCoach();
        System.out.println(coach.getDailyWorkout());
    }
}
