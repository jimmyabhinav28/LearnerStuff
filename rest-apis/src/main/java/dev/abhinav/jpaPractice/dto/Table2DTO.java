package dev.abhinav.jpaPractice.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.jpaPractice.entities.Table2;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table2DTO {
	
	@JsonProperty("table2_id")
	private Long id;
	
	@JsonProperty("table1_attribute1")
	private String attribute1;
	
	@JsonBackReference
	@JsonProperty("table3")
	Table3DTO table3;
	
	public Table2DTO(Table2 table2) {
		this.id = table2.getId();
		this.attribute1 = table2.getAttribute1();
	}

}
