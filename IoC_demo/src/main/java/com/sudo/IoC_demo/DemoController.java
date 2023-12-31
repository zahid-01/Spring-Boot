package com.sudo.IoC_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach coach;

    @Autowired
    public DemoController(Coach coach) {
        this.coach = coach;
    }

    public DemoController(Coach coach, String message){
        this.coach = coach;
        System.out.println(coach.getClass() + " " + message);
    }
    @GetMapping("/getWorkout")
    public String getWorkout(){
        return coach.getDailyWorkout();
    }
}
