package dev.abhinav.restapis.getAPis;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.abhinav.restapis.ParametersAndHeaders;

@RestController

public class Controller1 {

	@GetMapping(path = "/showAllParams/{a}/{b}")
	public ParametersAndHeaders showAllParameters(@RequestHeader Map<String,String> headers,@RequestParam Map<String,String> allQueryParams,@PathVariable Map<String,String> allPathVariables)
	{
		ParametersAndHeaders parametersAndHeaders=new ParametersAndHeaders();
		parametersAndHeaders.setHeaders(headers);
		parametersAndHeaders.setPathParameters(allPathVariables);
		parametersAndHeaders.setQueryParameters(allQueryParams);
		return parametersAndHeaders;
	}
}
