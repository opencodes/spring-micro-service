package com.techefx.microservices.productstockservice.techefxproductstockservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductStockController {

    @Autowired
    Environment environment;


    @GetMapping("/")
    public String checkProductStock() {

        return "productStockBean";
    }

}
