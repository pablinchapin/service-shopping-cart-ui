/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.tiendaliz.serviceshoppingcartui.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author pvargas
 */


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    
    @Bean 
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        
        
        log.info("ya en la conf");
        
        http
                .csrf().disable();
        
        http
                .authorizeRequests()
                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403");
        
        
        http
                .cors()
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                        .antMatchers(
                                "/",
                                "/error",
                                "/favicon.ico",
                                "/**/*.png",
                                "/**/*.gif",
                                "/**/*.svg",
                                "/**/*.jpg",
                                "/**/*.html",
                                "/**/*.css",
                                "/**/*.js"
                            )
                            .permitAll()
                .anyRequest()
                    .permitAll();
    
    }
    
    
     public SecurityConfig() {
        super();
    }
    
    
}
