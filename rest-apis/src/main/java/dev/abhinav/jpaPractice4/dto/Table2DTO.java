package dev.abhinav.jpaPractice4.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

//	@JsonManagedReference
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("table3_entity")
    Set<Table3DTO> table3dtos;
}
