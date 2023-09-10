package com.sudo.dev.ComponentScanningDemo.MainContainer.Common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Override
    public String getWorkout() {
        return "Play tennis";
    }
}
