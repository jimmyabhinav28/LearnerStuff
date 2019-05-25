package dev.abhinav.jpaPractice.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.jpaPractice.dto.Table3DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table3Response {
	
	@JsonProperty("data")
	Table3DTO data;

}
