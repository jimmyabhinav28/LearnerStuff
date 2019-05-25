package dev.abhinav.jpaPractice.service;

import org.springframework.stereotype.Component;

import dev.abhinav.jpaPractice.dto.Table2DTO;
import dev.abhinav.jpaPractice.dto.Table3DTO;
import dev.abhinav.jpaPractice.entities.Table2Entity;
import dev.abhinav.jpaPractice.entities.Table3Entity;

@Component
public class Table2Service {
	
 public static Table2DTO convertTable2EntityToTable2DTO(Table2Entity entity)
 {
	 Table2DTO dto=new Table2DTO();
	 dto.setId(entity.getId());
	 dto.setAttribute1(entity.getAttribute1());
	 Table3DTO table3dto=new Table3DTO();
	 table3dto.setId(entity.getTable3entity().getId());
	 table3dto.setAttribute1(entity.getTable3entity().getAttribute1());
	 table3dto.setTable2dto(dto);
	 dto.setTable3dto(table3dto);
	 return dto;
 }
 
 public static Table2Entity convertTable2DTOToTable2Entity(Table2DTO dto,Table3Entity table3Entity)
 {
	 Table2Entity entity=new Table2Entity();
	 entity.setId(dto.getId());
	 entity.setAttribute1(dto.getAttribute1());
	 //@abhinav: this was a source of error, I was creating another entity3 and hibernate was saving two records..i introduced the second parameter and fixed it
	 //Table3Entity table3Entity=new Table3Entity();
	 //table3Entity.setAttribute1(dto.getTable3dto().getAttribute1());
	 //table3Entity.setId(dto.getTable3dto().getId());
	 //table3Entity.setTable2Entity(entity);
	 entity.setTable3entity(table3Entity);
	 return entity;
 }
}
