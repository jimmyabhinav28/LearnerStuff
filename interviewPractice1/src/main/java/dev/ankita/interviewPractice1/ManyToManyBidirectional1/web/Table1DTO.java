package dev.ankita.interviewPractice1.ManyToManyBidirectional1.web;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table1DTO {

	Long id;
	String attribute1;
	
	@JsonManagedReference
	@JsonInclude(Include.NON_NULL)
	Set<Table3DTO> table3;

}
