package dev.abhinav.jpaPractice4.dto;

import java.util.Set;

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
    Set<Table3DTO> table3dtos;

}
