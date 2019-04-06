package com.pablinchapin.tiendaliz.serviceshoppingcartui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ServiceShoppingcartUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceShoppingcartUiApplication.class, args);
	}

}
