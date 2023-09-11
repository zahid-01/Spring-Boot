package com.sudo.dev.ComponentScanningDemo.MainContainer.Common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Component
public class TrackCoach implements Coach{

    public TrackCoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @Override
    public String getWorkout() {
        return "RUN RUN";
    }
}
