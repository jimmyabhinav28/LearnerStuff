package dev.abhinav.restapis.getAPis.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TwoNumbersOperationRequest {
	@Positive
	@Max(value = 500, message = "num1 should be less than 500")
	Double num1;

	@Max(value = 100, message = "num2 should be less than 100")
	Double num2;

	@Email(message = "email address is not well formed")
	String requestorEmailAddress;
}
