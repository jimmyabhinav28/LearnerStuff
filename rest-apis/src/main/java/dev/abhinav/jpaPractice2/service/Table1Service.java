package dev.abhinav.jpaPractice2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.abhinav.jpaPractice2.dao.Table1DAO;
import dev.abhinav.jpaPractice2.dto.Table1DTO;
import dev.abhinav.jpaPractice2.entities.Table1Entity;
import dev.abhinav.jpaPractice2.entities.Table3Entity;

@Component
public class Table1Service {
	
	@Autowired
	Table1DAO table1dao;
	
 public Table1DTO getById(Long id)
 {
	 return convertTable1EntityToTable1DTO(table1dao.getTable1EntityById(id));
 }

 public Table1DTO getByAttribute1(String attr1)
 {
	 return convertTable1EntityToTable1DTO(table1dao.getTable1EntityByAttribute1(attr1).get(0));
 }

 public static Table1DTO convertTable1EntityToTable1DTO(Table1Entity entity)
 {
	 Table1DTO dto=new Table1DTO();
	 dto.setAttribute1(entity.getAttribute1());
	 dto.setTable3dto(Table3Service.convertTable3EntityToTable3DTO(entity.getTable3(),entity.getTable3().getTable2entity()));
	 dto.setId(entity.getId());
	 return dto;
 }
 
 public static Table1Entity convertTable1DTOToTable1Entity(Table1DTO dto)
 {
	 Table1Entity entity=new Table1Entity();
	 entity.setId(dto.getId());
	 entity.setAttribute1(dto.getAttribute1());
	 entity.setTable3(Table3Service.convertTable3DtoToTable3Entity(dto.getTable3dto()));
	 return entity;
 }
}
