package com.rkjha.pheurekaserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PhEurekaServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhEurekaServiceRegistryApplication.class, args);
	}

}
