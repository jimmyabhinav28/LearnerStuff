package dev.abhinav.jpaPractice.service;

import org.springframework.stereotype.Component;

import dev.abhinav.jpaPractice.dto.Table1DTO;
import dev.abhinav.jpaPractice.entities.Table1Entity;

@Component
public class Table1Service {
	
 public static Table1DTO convertTable1EntityToTable1DTO(Table1Entity entity)
 {
	 Table1DTO dto=new Table1DTO();
	 dto.setAttribute1(entity.getAttribute1());
	 dto.setId(entity.getId());
	 return dto;
 }
 
 public static Table1Entity convertTable1DTOToTable1Entity(Table1DTO dto)
 {
	 Table1Entity entity=new Table1Entity();
	 entity.setId(dto.getId());
	 entity.setAttribute1(dto.getAttribute1());
	 return entity;
 }
}
