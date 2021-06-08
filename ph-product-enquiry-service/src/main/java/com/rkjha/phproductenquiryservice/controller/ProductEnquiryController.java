package com.rkjha.phproductenquiryservice.controller;

import com.rkjha.phproductenquiryservice.beans.ProductEnquiryBean;
import com.rkjha.phproductenquiryservice.client.ProductStockClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductEnquiryController {
    @Autowired
    private ProductStockClient client;

    @Autowired
    Environment env;

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
