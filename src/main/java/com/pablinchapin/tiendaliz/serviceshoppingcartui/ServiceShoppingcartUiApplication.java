package com.pablinchapin.tiendaliz.serviceshoppingcartui;

import com.pablinchapin.tiendaliz.serviceshoppingcartui.util.AuthHeaderFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ServiceShoppingcartUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceShoppingcartUiApplication.class, args);
	}
        
        
        @Bean
        AuthHeaderFilter authHeaderFilter(){
            return new AuthHeaderFilter();
        }
        
}
