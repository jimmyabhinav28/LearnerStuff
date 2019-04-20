package dev.abhinav.restapis.postAPIs;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.abhinav.restapis.ParametersAndHeaders;

@RestController
public class Controller2 {
	
	@PostMapping("/postRequestWithParamBody/{a}/{b}")
	public ParametersAndHeaders postRequestMethod (@RequestHeader Map<String, String> headers,
			@RequestParam Map<String, String> allQueryParams, @PathVariable Map<String, String> allPathVariables,
			@RequestBody  Map<String, String> reqBody) {
		ParametersAndHeaders parametersAndHeaders = new ParametersAndHeaders();
		parametersAndHeaders.setHeaders(headers);
		parametersAndHeaders.setPathParameters(allPathVariables);
		parametersAndHeaders.setQueryParameters(allQueryParams);
		parametersAndHeaders.setRequestBody(reqBody);
		return parametersAndHeaders;
		
	}

}
