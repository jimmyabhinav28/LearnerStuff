package dev.abhinav.restapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.abhinav.jpaPractice2"})
@EntityScan(basePackages = {"dev.abhinav.jpaPractice2"})
@EnableJpaRepositories(basePackages = {"dev.abhinav.jpaPractice2"})
/*
 * @ComponentScan(basePackages = {"dev.abhinav.jpaPractice"})
 * 
 * @EntityScan(basePackages = {"dev.abhinav.jpaPractice"})
 * 
 * @EnableJpaRepositories(basePackages = {"dev.abhinav.jpaPractice"})
 */
public class RestApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApisApplication.class, args);
	}
	
	@Bean
	RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

}
