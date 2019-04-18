package dev.abhinav.restapis.getAPis;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.abhinav.restapis.ParametersAndHeaders;

@RestController

public class Controller1 {

	/**
	 * This endpoint shows how to read all parameters in a request.
	 * 
	 * @param headers
	 * @param allQueryParams
	 * @param allPathVariables
	 * @return
	 */
	@GetMapping(path = "/showAllParams/{a}/{b}")
	public ParametersAndHeaders showAllParameters(@RequestHeader Map<String, String> headers,
			@RequestParam Map<String, String> allQueryParams, @PathVariable Map<String, String> allPathVariables) {
		ParametersAndHeaders parametersAndHeaders = new ParametersAndHeaders();
		parametersAndHeaders.setHeaders(headers);
		parametersAndHeaders.setPathParameters(allPathVariables);
		parametersAndHeaders.setQueryParameters(allQueryParams);
		return parametersAndHeaders;
	}

	/**
	 * Certain parameters must be mandatorily present in a request..How do we
	 * ascertain that We will see the use of annotation(s) to enforce such
	 * constraints The GET endpoint below will show 1)two mandatory header 2) 2
	 * mandatory query parameter and 3) 2 mandatory path parameters Play around by
	 * passing non-integer string in a parameter which requires an Integer not
	 * passing some mandatory parameters and all
	 */
	@GetMapping(path = "/mandatoryParameters/{a}/{b}")
	public ParametersAndHeaders showAllParametersWithConstraints(
			@NotBlank @RequestHeader(name = "mandatoryHeader1") String mandatoryHeader1,
			@NotNull @RequestHeader(name = "mandatoryHeader2") Integer mandatoryHeader2,
			@NotBlank @PathVariable(name = "a") String a, @NotBlank @PathVariable(name = "b") String b,
			@NotBlank @RequestParam(name = "mandatoryQP1") String mandatoryQueryParameter1,
			@NotBlank @RequestParam(name = "mandatoryQP2") String mandatoryQueryParameter2) {
		ParametersAndHeaders parametersAndHeaders = new ParametersAndHeaders();
		HashMap<String, String> mandatoryHeaders = new HashMap<String, String>();
		mandatoryHeaders.put("mandatoryHeader1", mandatoryHeader1);
		mandatoryHeaders.put("mandatoryHeader2", mandatoryHeader2.toString());
		HashMap<String, String> mandatoryPathParams = new HashMap<String, String>();
		mandatoryPathParams.put("a", a);
		mandatoryPathParams.put("b", b);
		HashMap<String, String> mandatoryQueryParams = new HashMap<String, String>();
		mandatoryQueryParams.put("mandatoryQP1", mandatoryQueryParameter1);
		mandatoryQueryParams.put("mandatoryQP2", mandatoryQueryParameter2);
		parametersAndHeaders.setHeaders(mandatoryHeaders);
		parametersAndHeaders.setPathParameters(mandatoryPathParams);
		parametersAndHeaders.setQueryParameters(mandatoryQueryParams);
		return parametersAndHeaders;
	}
}
