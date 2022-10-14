package com.example.ShoppingCartProduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShoppingCartProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartProductApplication.class, args);
	}

}
