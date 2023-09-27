package com.sudo.thymeleaf;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String sayHello(Model model){
        String name = "ZAhid Hussain";
        model.addAttribute("theDate", new java.util.Date());
        model.addAttribute("theName", name);
        return "helloWorld";
    }
}
