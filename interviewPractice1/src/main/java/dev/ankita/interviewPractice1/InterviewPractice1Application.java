package dev.ankita.interviewPractice1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "dev.ankita.interviewPractice1.ManyToManyBidirectional1" })
@EntityScan(basePackages = { "dev.ankita.interviewPractice1.ManyToManyBidirectional1" })
@EnableJpaRepositories(basePackages = { "dev.ankita.interviewPractice1.ManyToManyBidirectional1" })

public class InterviewPractice1Application {

	public static void main(String[] args) {
		SpringApplication.run(InterviewPractice1Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
