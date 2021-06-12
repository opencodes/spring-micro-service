package com.rkjha.phproductstockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PhProductStockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhProductStockServiceApplication.class, args);
	}

}
