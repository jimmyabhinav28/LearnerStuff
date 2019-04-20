package dev.abhinav.restapis.getAPis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import dev.abhinav.restapis.getAPis.dto.MathsOperation;
import dev.abhinav.restapis.getAPis.dto.MathsOperationsInCapsOnly;
import dev.abhinav.restapis.getAPis.dto.MockyResponse1;
import dev.abhinav.restapis.getAPis.dto.TwoNumbersMathsOperationResponse;

@Component
public class Services {
	
	@Autowired
	RestTemplate restTemplate;

	public TwoNumbersMathsOperationResponse operate(Double num1, Double num2, String operation, String requestorEmailId,
			boolean onlyCapsEnumWalaCase) {
		if (onlyCapsEnumWalaCase)
			return operate2(num1, num2, operation, requestorEmailId);
		else
			return operate1(num1, num2, operation, requestorEmailId);
	}

	private TwoNumbersMathsOperationResponse operate1(Double num1, Double num2, String operation,
			String requestorEmailId) {

		TwoNumbersMathsOperationResponse response = new TwoNumbersMathsOperationResponse();
		response.setRequestedBy(requestorEmailId);
		response.setNum1(num1);
		response.setNum2(num2);
		response.setOperation(operation);
//		response.setOperation(operation.toUpperCase());
		MathsOperation op = MathsOperation.valueOf(operation);
		if (op == MathsOperation.ADD || op == MathsOperation.add)
			response.setResult(num2 + num1);
		if (op == MathsOperation.SUBTRACT || op == MathsOperation.subtract)
			response.setResult(num1 - num2);
		if (op == MathsOperation.MULTIPLY || op == MathsOperation.multiply)
			response.setResult(num1 * num2);
		if (op == MathsOperation.DIVIDE || op == MathsOperation.divide)
			response.setResult(num1 / num1);
		if (op == MathsOperation.REMAINDER || op == MathsOperation.remainder)
			response.setResult(num1 % num2);
		return response;

	}

	private TwoNumbersMathsOperationResponse operate2(Double num1, Double num2, String operation,
			String requestorEmailId) {

		TwoNumbersMathsOperationResponse response = new TwoNumbersMathsOperationResponse();
		response.setRequestedBy(requestorEmailId);
		response.setNum1(num1);
		response.setNum2(num2);
//		response.setOperation(operation);
		response.setOperation(operation.toUpperCase());
		MathsOperationsInCapsOnly op = MathsOperationsInCapsOnly.valueOf(operation.toUpperCase());
		if (op == MathsOperationsInCapsOnly.ADD)
			response.setResult(num2 + num1);
		if (op == MathsOperationsInCapsOnly.SUBTRACT)
			response.setResult(num1 - num2);
		if (op == MathsOperationsInCapsOnly.MULTIPLY)
			response.setResult(num1 * num2);
		if (op == MathsOperationsInCapsOnly.DIVIDE)
			response.setResult(num1 / num1);
		if (op == MathsOperationsInCapsOnly.REMAINDER)
			response.setResult(num1 % num2);
		return response;

	}
	
	/*
	 * public MockyResponse1 getResponseFromMocky() { MockyResponse1
	 * mockyResponse1=new MockyResponse1(); //pass headers, pass query paremeters,
	 * pass pathParameters, pass request body to a call UriComponentsBuilder
	 * builder=UriComponentsBuilder.newInstance();
	 * //http://www.mocky.io/v2/5cb8c3034c0000c51ad3d73d
	 * builder=builder.host("www.mocky.io"); builder=builder.port(80);
	 * builder=builder.path("v2/5cb8c3034c0000c51ad3d73d"); MultiValueMap<String,
	 * List<String>> queryParams = new LinkedMultiValueMap<>();
	 * queryParams.put("key1","value1"); builder.queryParams(queryParams);
	 * 
	 * //add some headers now
	 * 
	 * MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
	 * headers.put("hkey1","hValue1"); HttpEntity entity=new HttpEntity(headers);
	 * 
	 * //Only headers are relevant in Get Request. Body is ignored RestTemplate
	 * restTemplate=new RestTemplate(); ResponseEntity<X> response =
	 * restTemplate.exchange(builder.build().toUri(), HttpMethod.GET,
	 * requestEntity,X);
	 * 
	 * return mockyResponse1; }
	 */
}
