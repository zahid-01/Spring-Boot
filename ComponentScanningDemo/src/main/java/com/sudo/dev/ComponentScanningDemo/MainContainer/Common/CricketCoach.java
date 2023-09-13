package com.sudo.dev.ComponentScanningDemo.MainContainer.Common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getWorkout() {
        return "Practice fast bowling for one hour\nPractice spin for 3 hours";
    }

    @PostConstruct
    public void init(){
        System.out.println("Doing initializing stuff: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void destruct(){
        System.out.println("Destructing" + getClass().getSimpleName());
    }
}
