package dev.abhinav.restapis.getAPis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwoNumbersMathsOperationResponse {

	private Double num1;
	private Double num2;
	private String operation;
	private String requestedBy;
	private Double result;
}
