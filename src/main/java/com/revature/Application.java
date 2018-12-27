package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * The Class Application.
 * Zuul’s rule engine lets rules and 
 * filters be written in essentially 
 * any JVM language, with built-in 
 * support for Java and Groovy.
 * 
 * Spring Cloud Netflix includes an 
 * embedded Zuul proxy, which we can 
 * enable with the EnableZuulProxy 
 * annotation. 
 * This will turn the Gateway application 
 * into a reverse proxy that forwards 
 * relevant calls to other services
 * 
 * @author 1811-Java-Nick | 12/27/2018
 */
@SpringBootApplication
@EnableZuulProxy
public class Application {
	
	/**
	 * Cors filter.
	 *  RESTful web service with 
	 *  Spring that includes headers 
	 *  for Cross-Origin Resource 
	 *  Sharing (CORS) in the response.
	 *
	 * @return the configured CorsFilter
	 */
	@Bean
	public CorsFilter corsFilter() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    final CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("OPTIONS");
	    config.addAllowedMethod("HEAD");
	    config.addAllowedMethod("GET");
	    config.addAllowedMethod("PUT");
	    config.addAllowedMethod("POST");
	    config.addAllowedMethod("DELETE");
	    config.addAllowedMethod("PATCH");
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	
}
