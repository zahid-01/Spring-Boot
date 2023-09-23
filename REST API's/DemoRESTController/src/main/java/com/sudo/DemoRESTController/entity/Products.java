package com.sudo.DemoRESTController.entity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class Products {
    @GetMapping("/getProducts")
    public String getAllProducts(){
        return "HP OEM laptop";
    }
}
