package com.spring;

public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run 40 Tracks";
    }

    @Override
    public String getDailyFortune() {
        return "";
    }
}
