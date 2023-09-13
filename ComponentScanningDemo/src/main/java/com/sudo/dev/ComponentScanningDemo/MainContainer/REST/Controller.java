package com.sudo.dev.ComponentScanningDemo.MainContainer.REST;

import com.sudo.dev.ComponentScanningDemo.MainContainer.Common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final Coach coach;
    private final Coach theCoach;

    public Controller(@Qualifier("cricketCoach") Coach coach, @Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("In constructor " + getClass().getSimpleName());
        this.coach = coach;
        this.theCoach = theCoach;
    }

    @GetMapping("/getWorkout")
    public String getWorkoutCricket() {
        return coach.getWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Checking if coach == theCoach" + " " + (coach == theCoach);
    }
}
