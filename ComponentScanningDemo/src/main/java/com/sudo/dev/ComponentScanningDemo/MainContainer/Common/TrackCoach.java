package com.sudo.dev.ComponentScanningDemo.MainContainer.Common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Component
public class TrackCoach implements Coach{

    @Override
    public String getWorkout() {
        return "RUN RUN";
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
