/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Cna
 */
@SpringBootApplication
public class App {
        public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
        
        @Bean
    	public WebMvcConfigurer corsConfigurer() {
    		return new WebMvcConfigurer() {
    			@Override
    			public void addCorsMappings(CorsRegistry registry) {
    				registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    			}
    		};
    	}
}
