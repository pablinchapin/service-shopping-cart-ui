package com.pablinchapin.tiendaliz.serviceshoppingcartui;

import com.pablinchapin.tiendaliz.serviceshoppingcartui.util.AuthHeaderFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableZuulProxy
@SpringBootApplication
public class ServiceShoppingcartUiApplication {

        
        @Bean
        //@LoadBalanced
        public RestTemplate restTemplate(){
            return new RestTemplate();
        }
    
        
        @Bean
        AuthHeaderFilter authHeaderFilter(){
            return new AuthHeaderFilter();
        }
    
    
	public static void main(String[] args) {
		SpringApplication.run(ServiceShoppingcartUiApplication.class, args);
	}
        
        
  
        
}
