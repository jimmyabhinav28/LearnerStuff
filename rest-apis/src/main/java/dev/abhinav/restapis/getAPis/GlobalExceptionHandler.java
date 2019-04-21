package dev.abhinav.restapis.getAPis;

import java.net.URISyntaxException;
import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends DefaultHandlerExceptionResolver {
	@ExceptionHandler(URISyntaxException.class)
	@ResponseStatus(code=HttpStatus.SERVICE_UNAVAILABLE)
	@ResponseBody
	public GenericErrorResponse handleError(URISyntaxException e)
	{
		log.error(e.getMessage(),e);
		GenericErrorResponse errorResponse=new GenericErrorResponse();
		errorResponse.setErrorMessage(e.getMessage());
		errorResponse.setErrorCode("RUNTIME_001");
		errorResponse.setResponseId(UUID.randomUUID().toString());
		errorResponse.setRequestId(MDC.get("X-B3-TraceId"));
		return errorResponse;
	}
	
}
