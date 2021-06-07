package com.rkjha.phproductstockservice.controller;

import com.rkjha.phproductstockservice.beans.ProductStockBean;
import com.rkjha.phproductstockservice.entity.ProductStockRepository;
import com.rkjha.phproductstockservice.entity.ProductStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductStockController {
    @Autowired
    ProductStockRepository productStockRepository;
    @Autowired
    Environment env;

    @GetMapping("/check-product-stock/productName/{productName}/productAvailability/{productAvailability}")
    public ProductStockBean checkProductStock(@PathVariable String productName,
                                              @PathVariable String productAvailability){
        ProductStockBean productStockBean = new ProductStockBean();
        ProductStock productStock = productStockRepository.findByProductNameAndProductAvailability(productName,productAvailability);
        if (productStock !=null){
             productStockBean = new ProductStockBean(
                    productStock.getId(),
                    productStock.getProductName(),
                    productStock.getProductPrice(),
                    productStock.getProductAvailability(),
                    productStock.getDiscountOffer(),
                    Integer.parseInt(env.getProperty("local.server.port"))
            );
        }


        return productStockBean;
    }
}
