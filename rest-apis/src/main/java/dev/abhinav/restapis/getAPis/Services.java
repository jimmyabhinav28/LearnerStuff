package dev.abhinav.restapis.getAPis;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import dev.abhinav.restapis.getAPis.dto.MathsOperation;
import dev.abhinav.restapis.getAPis.dto.MathsOperationsInCapsOnly;
import dev.abhinav.restapis.getAPis.dto.MockyResponse1;
import dev.abhinav.restapis.getAPis.dto.TwoNumbersMathsOperationResponse;
import dev.abhinav.restapis.utils.GenericRestClient;
import dev.abhinav.restapis.utils.RestClientException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Services {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	GenericRestClient restClientUtils;

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

	public MockyResponse1 getResponseFromMocky() throws DownStreamAPICallException {
		MockyResponse1 mockyResponse1 = new MockyResponse1();
		String hostname = "www.mocky.io";
		Integer port = 80;
		String resourcePath = "/{mockyVersion}/5cbb39ff31000064194d74c4";

		Map<String, String> pathVariables = new LinkedHashMap<>();
		// pathVariables.put("mockyVersion", "v2");
		pathVariables.put("wrongPathParameterKey", "v2");

		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
		queryParams.add("key1", "value1");

		// add some headers now

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("hkey1", "hValue1");

		String scheme = "http";

		ResponseEntity<MockyResponse1> response = null;
		try {
			response = restClientUtils.makeGetCall(scheme, hostname, port, resourcePath, pathVariables, queryParams,
					headers, MockyResponse1.class);
		} catch (RestClientException e) {
			String message= "Error getting response from mocky";
			log.error(message,e);
			throw new DownStreamAPICallException(message, e);
		}
		return response.getBody();
	}

}
