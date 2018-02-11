package com.fapps.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
//@EnableAutoConfiguration
@EnableDiscoveryClient
public class SubstracterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubstracterServiceApplication.class, args);
	}
	
	@Bean
	public Sampler alwaysSample() {
		return new AlwaysSampler();
	}
}
