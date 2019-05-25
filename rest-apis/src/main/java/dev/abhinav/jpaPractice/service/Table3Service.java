package dev.abhinav.jpaPractice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.abhinav.jpaPractice.dao.Table3DAO;
import dev.abhinav.jpaPractice.dao.Table3DAOException;
import dev.abhinav.jpaPractice.dto.Table3DTO;
import dev.abhinav.jpaPractice.entities.Table3Entity;

@Component
public class Table3Service {

	@Autowired
	Table3DAO table3DAO;
	
	public Table3DTO save(Table3DTO table3dto)
	{
		Table3Entity entity=convertTable3DtpToTable3Entity(table3dto);
		entity= table3DAO.save(entity);
		return convertTable3EntityToTable3DTO(entity);
	}
	
	public void deleteByAttribute1(String attribute1Value)
	{
		List<Table3Entity> table3Entities= table3DAO.getByAttribute1Value(attribute1Value);
		for(Table3Entity entity: table3Entities)
		{
			table3DAO.deleteById(entity.getId());
		}
	}
	
	public void deleteById(Long id)
	{
		table3DAO.deleteById(id);
	}
	
	public List<Table3DTO> getByAttribute1Value(String attribute1Value)
	{
		List<Table3DTO> table3dtos=new ArrayList<Table3DTO>();
		List<Table3Entity> entities= table3DAO.getByAttribute1Value(attribute1Value);
		for(Table3Entity entity: entities)
		{
			Table3DTO dto=convertTable3EntityToTable3DTO(entity);
			table3dtos.add(dto);
		}
		return table3dtos;
	}
	
	public Table3Entity getById(Long id)
	{
		return table3DAO.getById(id);
	}
	
	public Table3DTO update(Table3DTO dto) throws Table3ServiceException
	{
		Table3Entity entity=convertTable3DtpToTable3Entity(dto);
		try {
			entity=table3DAO.update(entity);
		} catch (Table3DAOException e) {
			e.printStackTrace();
			throw new Table3ServiceException("error updating table3 record",e);
		}
		return convertTable3EntityToTable3DTO(entity);
	}
	
	public static Table3DTO convertTable3EntityToTable3DTO(Table3Entity entity)
	{
		Table3DTO dto=new Table3DTO();
		dto.setAttribute1(entity.getAttribute1());
		dto.setId(entity.getId());
		dto.setTable1dto(Table1Service.convertTable1EntityToTable1DTO(entity.getTable1Entity()));
		dto.setTable2dto(Table2Service.convertTable2EntityToTable2DTO(entity.getTable2Entity()));
		return dto;
	}
	
	public static Table3Entity convertTable3DtpToTable3Entity(Table3DTO dto)
	{
		Table3Entity entity=new Table3Entity();
		entity.setAttribute1(dto.getAttribute1());
		entity.setId(dto.getId());
		entity.setTable1Entity(Table1Service.convertTable1DTOToTable1Entity(dto.getTable1dto()));
		entity.setTable2Entity(Table2Service.convertTable2DTOToTable2Entity(dto.getTable2dto()));
		return entity;
	}
	}
