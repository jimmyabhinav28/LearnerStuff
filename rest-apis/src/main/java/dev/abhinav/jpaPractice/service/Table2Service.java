package dev.abhinav.jpaPractice.service;

import org.springframework.stereotype.Component;

import dev.abhinav.jpaPractice.dto.Table2DTO;
import dev.abhinav.jpaPractice.entities.Table2Entity;

@Component
public class Table2Service {
	
 public static Table2DTO convertTable2EntityToTable2DTO(Table2Entity entity)
 {
	 Table2DTO dto=new Table2DTO();
	 return dto;
 }
 
 public static Table2Entity convertTable2DTOToTable2Entity(Table2DTO dto)
 {
	 Table2Entity entity=new Table2Entity();
	 return entity;
 }
}
