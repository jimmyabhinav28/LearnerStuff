package dev.abhinav.restapis.getAPis;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericErrorResponse {
	
	@JsonProperty("error_message")
	String errorMessage;
	
	@JsonProperty("error_code")
	String errorCode;
	
	@JsonProperty("response_id")
	String responseId;
	
	@JsonProperty("request_id")
	String requestId;

}
