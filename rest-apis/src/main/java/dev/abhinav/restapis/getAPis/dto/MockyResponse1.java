package dev.abhinav.restapis.getAPis.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MockyResponse1 {
/**
 * {
    "name":"abhinav",
    "surname":"anand",
    "date_of_birth":"28/09/1989",
    "lucky_number":10,
}
  
 */
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("surname")
	private String surname;
	
	@JsonProperty("date_of_birth")
	private String dateOfBirth;
	
	@JsonProperty("lucky_number")
	private Integer luckyNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("call_time")
	private String callTime;
}
