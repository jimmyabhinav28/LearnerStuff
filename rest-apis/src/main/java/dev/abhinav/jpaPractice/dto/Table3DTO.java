package dev.abhinav.jpaPractice.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.jpaPractice.entities.Table1;
import dev.abhinav.jpaPractice.entities.Table2;
import dev.abhinav.jpaPractice.entities.Table3;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table3DTO {
	
	@JsonProperty("table3_id")
	private Long id;
	
	@JsonProperty("table3_attribute1")
	private String attribute1;
	
	@JsonProperty("table1")
	private Table1 table1;
	
	//you are referring Table2 but Table2DTO par JsonBackReference lagayi thi...waah !
	@JsonManagedReference
	@JsonProperty("table2")
	private Table2 table2;	
	
	public Table3DTO(Table3 table3) {
		this.id = table3.getId();
		this.attribute1 = table3.getAttribute1();
		this.table1 = table3.getTable1();
		this.table2 = table3.getTable2();
		
	}

}
