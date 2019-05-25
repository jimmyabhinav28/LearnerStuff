package dev.abhinav.jpaPractice.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Table2DTO {

	@JsonProperty(value = "id")
	Long id;

	@JsonProperty(value = "attribute1_value")
	String attribute1;

	@JsonBackReference
	@JsonProperty("table3_entity")
	Table3DTO table3dto;
}
