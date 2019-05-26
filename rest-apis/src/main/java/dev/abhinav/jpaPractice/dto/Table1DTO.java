package dev.abhinav.jpaPractice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.jpaPractice2.dto.Table3DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table1DTO {

	@JsonProperty(value = "id")
	Long id;

	@JsonProperty("table3_entity")
	Table3DTO table3DTO;
	
	@JsonProperty(value = "attribute1_value")
	String attribute1;

}
