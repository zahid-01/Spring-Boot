package com.sudo.mvc.controller;

import com.sudo.mvc.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("customer", new Customer());

        return "form";
    }

    @PostMapping("processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "form";
        return "confirmation";
    }

}
