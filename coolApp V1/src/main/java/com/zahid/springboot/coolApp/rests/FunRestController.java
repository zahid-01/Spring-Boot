package com.zahid.springboot.coolApp.rests;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    @Value("${owner.name}")
    private String ownerName;

    @GetMapping("/hi")
    public String sayHi(){
        return "Hello" + ownerName;
    }

}
