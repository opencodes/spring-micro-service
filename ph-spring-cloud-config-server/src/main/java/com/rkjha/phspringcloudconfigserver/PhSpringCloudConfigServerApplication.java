package com.rkjha.phspringcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class PhSpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhSpringCloudConfigServerApplication.class, args);
	}

}
