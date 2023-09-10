package com.sudo.dev.ComponentScanningDemo.MainContainer.Common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    @Override
    public String getWorkout() {
        return "Dribble";
    }
}
