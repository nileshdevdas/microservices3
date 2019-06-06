package com.tsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmpClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpClientApplication.class, args);
	}

}
