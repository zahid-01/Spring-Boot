package com.sudo.dev.ComponentScanningDemo.MainContainer.Common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Override
    public String getWorkout() {
        return "Play tennis";
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
