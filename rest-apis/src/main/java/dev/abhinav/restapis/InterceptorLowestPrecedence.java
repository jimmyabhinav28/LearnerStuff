package dev.abhinav.restapis;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.bcel.classfile.EnumElementValue;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
@Slf4j
public class InterceptorLowestPrecedence implements HandlerInterceptor{
	
	
	@Override
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("Prehandled in interceptor with lowest precendence");
		//throw new Exception("just like that");
		Enumeration<String> allHeaderNames= request.getHeaderNames();
		while(allHeaderNames.hasMoreElements())
		{
			String header=allHeaderNames.nextElement();
			String headerValue=request.getHeader(header);
			log.info(header+" : "+headerValue);
		}
		
		return true;
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		log.info("post handled in interceptor with lowest precendence");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("After completion in interceptor with lowest precendence");
	}

}
