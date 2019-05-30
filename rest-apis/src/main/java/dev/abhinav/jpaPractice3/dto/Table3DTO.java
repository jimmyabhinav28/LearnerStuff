package dev.abhinav.jpaPractice3.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Table3DTO {

	@JsonProperty(value = "id")
	Long id;

	@JsonProperty(value = "attribute1_value")
	String attribute1;
	
//	@JsonBackReference
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("table2_entity")
	Set<Table2DTO> table2DTOS;
}