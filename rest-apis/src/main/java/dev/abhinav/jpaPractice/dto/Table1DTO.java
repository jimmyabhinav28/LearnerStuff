package dev.abhinav.jpaPractice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.jpaPractice.entities.Table1;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table1DTO {
	
	@JsonProperty("table1_id")
	private Long id;
	
	@JsonProperty("table1_attribute1")
	private String attribute1;
	
	public Table1DTO(Table1 table1) {
		this.id = table1.getId();
		this.attribute1 = table1.getAttribute1();
	}

}
