package com.sudo.dev.ComponentScanningDemo.MainContainer.Common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach{
    @Override
    public String getWorkout() {
        return "Practice fast bowling for one hour\nPractice spin for 3 hours";
    }
}
