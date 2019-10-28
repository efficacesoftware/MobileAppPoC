package com.mobileappservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableAsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableAsync;

@SuppressWarnings("deprecation")
@Configuration
@EnableAsync
@EnableAutoConfiguration
@ComponentScan("com.mobileappservice")
@ImportResource({ "classpath:spring-dao-config.xml" })
@PropertySources({ @PropertySource(value = "classpath:application.properties"), })
public class Service {

	public static void main(String[] args) {
		SpringApplication.run(Service.class, args);
		
		System.out.println("\n Hi welcome !!!!! user mobile service....");
		
	}

}
