package dev.abhinav.restapis.getAPis;

import org.springframework.stereotype.Component;

import dev.abhinav.restapis.getAPis.dto.MathsOperation;
import dev.abhinav.restapis.getAPis.dto.MathsOperationsInCapsOnly;
import dev.abhinav.restapis.getAPis.dto.TwoNumbersMathsOperationResponse;

@Component
public class Services {

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
}
