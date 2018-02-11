package com.fapps.micro.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
//@EnableOAuth2Sso
@SpringBootApplication
public class ApiGatewayApplication { //extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
	public Sampler alwaysSample() {
		return new AlwaysSampler();
	}
//	
//	  @Override
//	  protected void configure(HttpSecurity http) throws Exception {
//	    http
//	      .antMatcher("/**")
//	      .authorizeRequests()
//	        .antMatchers("/", "/login**", "/webjars/**")
//	        .permitAll()
//	      .anyRequest()
//	        .authenticated();
//	  }
}
