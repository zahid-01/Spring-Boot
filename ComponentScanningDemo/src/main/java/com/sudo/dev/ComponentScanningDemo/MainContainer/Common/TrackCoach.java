package com.sudo.dev.ComponentScanningDemo.MainContainer.Common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getWorkout() {
        return "RUN RUN";
    }
}
