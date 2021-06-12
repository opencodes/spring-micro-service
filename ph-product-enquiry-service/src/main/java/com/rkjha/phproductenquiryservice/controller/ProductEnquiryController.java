package com.rkjha.phproductenquiryservice.controller;

import com.rkjha.phproductenquiryservice.beans.ProductEnquiryBean;
import com.rkjha.phproductenquiryservice.client.ProductStockClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductEnquiryController {
    @Autowired
    private ProductStockClient client;

    @Autowired
    Environment env;

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String ping(){
      return   client.pingServer();
    }

    @RequestMapping("/ping")
    public String hi() {
        String port = this.restTemplate.getForObject("http://productservice/ping", String.class);
        return String.format("%s: %s", "port", port);
    }

    @GetMapping("/productEnquiry/name/{name}/availability/{availability}/unit/{unit}")
    public ProductEnquiryBean getEnquiryOfProduct(@PathVariable String name,
                                                  @PathVariable String availability,
                                                  @PathVariable int unit){

        ProductEnquiryBean productEnquiryBean = client.checkProductStock(name, availability);
        double totalPrice =  Double.valueOf(String.valueOf(productEnquiryBean.getProductPrice())) * Double.valueOf(unit);
        double discountPercent = productEnquiryBean.getDiscountOffer();
        double discountedPrice = totalPrice - (totalPrice * discountPercent / 100);
        System.out.println("totalPrice = " + productEnquiryBean.getTotalPrice() + ", discountPercent = " + discountPercent + ", discountedPrice = " + discountedPrice);
        return new ProductEnquiryBean(
                productEnquiryBean.getId(),
                name,
                productEnquiryBean.getProductPrice(),
                availability,
                productEnquiryBean.getDiscountOffer(),
                unit,
                discountedPrice,
                productEnquiryBean.getPort()
        );
    }
}
