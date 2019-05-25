package dev.abhinav.jpaPractice.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table3DTO {

	@JsonProperty(value = "id")
	Long id;

	@JsonProperty(value = "attribute1_value")
	String attribute1;
	
	@JsonProperty("table1_entity")
	Table1DTO table1dto;
	
	@JsonManagedReference
	@JsonProperty("table2_entity")
	Table2DTO table2dto;
}
