package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableHystrix
public class VaccineCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccineCenterApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestemplate() {

		final RestTemplate restTemplate = new RestTemplate();

		return restTemplate;
		// return new RestTemplate();
	}

}
