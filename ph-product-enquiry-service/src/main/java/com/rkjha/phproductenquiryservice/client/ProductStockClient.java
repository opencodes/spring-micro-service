package com.rkjha.phproductenquiryservice.client;

import com.rkjha.phproductenquiryservice.beans.ProductEnquiryBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PH-PRODUCT-STOCK-SERVICE")
public interface ProductStockClient {

    @GetMapping("/check-product-stock/productName/{productName}/productAvailability/{productAvailability}")
    public ProductEnquiryBean checkProductStock(@PathVariable String productName, @PathVariable String productAvailability);

    @GetMapping("/ping")
    public String pingServer();
}
