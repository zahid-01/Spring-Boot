package com.sudo.dev.ComponentScanningDemo.MainContainer.REST;

import com.sudo.dev.ComponentScanningDemo.MainContainer.Common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final Coach coach;

    public Controller(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/getWorkout")
    public String getWorkoutCricket() {
        return coach.getWorkout();
    }
}
