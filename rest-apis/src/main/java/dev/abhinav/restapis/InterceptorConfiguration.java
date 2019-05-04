package dev.abhinav.restapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
	@Autowired
	InterceptorHighestPrecedence interceptorHighestPrecedence;

	@Autowired
	InterceptorLowestPrecedence interceptorLowestPrecedence;

	@Autowired
	Interceptor1 interceptor1;
	@Autowired
	Interceptor2 interceptor2;

	//what i see is that the order in which the interceptors are executed in not 
	//as per the @Order but as in the order in which they were added to registry
	
	//aftercompletion follows same order as postHandle
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//registry.addInterceptor(interceptorLowestPrecedence);
		//registry.addInterceptor(interceptorHighestPrecedence);
		//registry.addInterceptor(interceptor1);
		//registry.addInterceptor(interceptor2);
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
