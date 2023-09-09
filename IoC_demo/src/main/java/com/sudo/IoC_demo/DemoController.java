package com.sudo.IoC_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach coach;

    public DemoController(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/getWorkout")
    public String getWorkout(){
        return coach.getDailyWorkout();
    }
}
