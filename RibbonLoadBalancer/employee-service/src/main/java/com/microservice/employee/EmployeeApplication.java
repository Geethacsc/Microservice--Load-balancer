package com.microservice.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
//@ImportAutoConfiguration({FeignAutoConfiguration.class})//to solve feignContext bean not found if spring boot doesn't auto configure Feign client
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}


}
