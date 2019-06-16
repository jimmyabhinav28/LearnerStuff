package dev.ankita.interviewPractice1.ManyToManyBidirectional1.web;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import dev.ankita.interviewPractice1.ManyToManyBidirectional1.dao.Table1Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table3DTO {
	Long id;
	String attribute1;
	
	@JsonBackReference
	@JsonInclude(Include.NON_NULL)
	Set<Table1DTO> table1;

}
