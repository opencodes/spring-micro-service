package com.rkjha.microservice.phpropertyaccessservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class PhPropertyAccessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhPropertyAccessServiceApplication.class, args);
	}

}
