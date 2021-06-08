package com.rkjha.phproductenquiryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.rkjha.phproductenquiryservice")
@SpringBootApplication
public class PhProductEnquiryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhProductEnquiryServiceApplication.class, args);
	}

}
