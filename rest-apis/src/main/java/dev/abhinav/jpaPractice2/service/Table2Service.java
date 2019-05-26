package dev.abhinav.jpaPractice2.service;

import org.springframework.stereotype.Component;

import dev.abhinav.jpaPractice2.dto.Table2DTO;
import dev.abhinav.jpaPractice2.dto.Table3DTO;
import dev.abhinav.jpaPractice2.entities.Table2Entity;
import dev.abhinav.jpaPractice2.entities.Table3Entity;

@Component
public class Table2Service {
	
 public static Table2DTO convertTable2EntityToTable2DTO(Table2Entity entity)
 {
	 Table2DTO dto=new Table2DTO();
	 dto.setId(entity.getId());
	 dto.setAttribute1(entity.getAttribute1());
	 Table3DTO table3dto=new Table3DTO();
	 dto.setTable3dto(Table3Service.convertTable3EntityToTable3DTO(entity.getTable3(),entity));
	 return dto;
 }
 
 public static Table2Entity convertTable2DTOToTable2Entity(Table2DTO dto)
 {
	 Table2Entity entity=new Table2Entity();
	 entity.setId(dto.getId());
	 entity.setAttribute1(dto.getAttribute1());
	 entity.setTable3(Table3Service.convertTable3DtoToTable3Entity(dto.getTable3dto()));
	 return entity;
 }
}
