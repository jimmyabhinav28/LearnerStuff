package dev.abhinav.jpaPractice4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table1DTO {

	@JsonProperty(value = "id")
	Long id;

	@JsonProperty(value = "attribute1_value")
	String attribute1;
	
	@JsonProperty("table3")
    Table3DTO table3dto;

}
