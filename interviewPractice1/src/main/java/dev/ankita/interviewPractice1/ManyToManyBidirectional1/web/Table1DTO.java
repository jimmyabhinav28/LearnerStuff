package dev.ankita.interviewPractice1.ManyToManyBidirectional1.web;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import dev.ankita.interviewPractice1.ManyToManyBidirectional1.dao.Table3Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table1DTO {

	Long id;
	String attribute1;
	Set<Table3DTO> table3;

}
