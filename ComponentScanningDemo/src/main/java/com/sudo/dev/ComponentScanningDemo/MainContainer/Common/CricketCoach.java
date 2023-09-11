package com.sudo.dev.ComponentScanningDemo.MainContainer.Common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @Override
    public String getWorkout() {
        return "Practice fast bowling for one hour\nPractice spin for 3 hours";
    }
}
