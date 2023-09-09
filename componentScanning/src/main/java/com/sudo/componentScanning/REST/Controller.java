package com.sudo.componentScanning.REST;

import Util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final Coach coach;

    @Autowired
    public Controller(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/getWorkout")
    public String getWorkout() {
        return coach.getDailyWorkout();
    }
}
