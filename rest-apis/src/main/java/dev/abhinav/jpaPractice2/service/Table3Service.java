package dev.abhinav.jpaPractice2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.abhinav.jpaPractice2.dao.Table1DAO;
import dev.abhinav.jpaPractice2.dao.Table3DAO;
import dev.abhinav.jpaPractice2.dao.Table3DAOException;
import dev.abhinav.jpaPractice2.dto.Table2DTO;
import dev.abhinav.jpaPractice2.dto.Table3DTO;
import dev.abhinav.jpaPractice2.entities.Table2Entity;
import dev.abhinav.jpaPractice2.entities.Table3Entity;

@Component
public class Table3Service {

	@Autowired
	Table3DAO table3DAO;
	@Autowired
	Table1DAO table1DAO;

	public Table3DTO save(Table3DTO table3dto)
	{
		Table3Entity entity=convertTable3DtoToTable3Entity(table3dto,true);
		entity= table3DAO.save(entity);
		return convertTable3EntityToTable3DTO(entity,true);
	}

	public void deleteByAttribute1(String attribute1Value) {
		List<Table3Entity> table3Entities = table3DAO.getByAttribute1Value(attribute1Value);
		for (Table3Entity entity : table3Entities) {
			table3DAO.deleteById(entity.getId());
		}
	}

	public void deleteById(Long id) {
		table1DAO.delete(id); //note i had to do this while using MapsId. MapsId is not suitable for one-one unidirectional..you do not have a reference to table1 in Table3Entity, hence JPA will not generate select, update, create, delete queries for the same..let's test this in the @JoinColumn way of 1-to-1 as well
		table3DAO.deleteById(id);
	}

	public List<Table3DTO> getByAttribute1Value(String attribute1Value)
	{
		List<Table3DTO> table3dtos=new ArrayList<Table3DTO>();
		List<Table3Entity> entities= table3DAO.getByAttribute1Value(attribute1Value);
		for(Table3Entity entity: entities)
		{
			Table3DTO dto=convertTable3EntityToTable3DTO(entity,true);
			table3dtos.add(dto);
		}
		return table3dtos;
	}

	public Table3DTO getById(Long id)
	{
		Table3DTO dto=null;
		Table3Entity entity= table3DAO.getById(id);
		dto=convertTable3EntityToTable3DTO(entity,true);
		return dto;
	}

	public Table3DTO update(Table3DTO dto) throws Table3ServiceException
	{
		Table3Entity entity=convertTable3DtoToTable3Entity(dto,true);
		try {
			entity=table3DAO.update(entity);
		} catch (Table3DAOException e) {
			e.printStackTrace();
			throw new Table3ServiceException("error updating table3 record",e);
		}
		return convertTable3EntityToTable3DTO(entity,true);
	}

	public static Table3DTO convertTable3EntityToTable3DTO(Table3Entity entity, boolean marshallTable2Stuff) {
		Table3DTO dto = new Table3DTO();
		dto.setAttribute1(entity.getAttribute1());
		dto.setId(entity.getId());
		if (entity.getTable2entity() != null && marshallTable2Stuff)
			dto.setTable2dto(
					Table2Service.convertTable2EntityToTable2DTO(entity.getTable2entity(), !marshallTable2Stuff));
		return dto;
	}

	public static Table3Entity convertTable3DtoToTable3Entity(Table3DTO dto, boolean marshallTable2Stuff) {
		Table3Entity entity = new Table3Entity();
		entity.setAttribute1(dto.getAttribute1());
		entity.setId(dto.getId());
		if (dto.getTable2dto() != null && marshallTable2Stuff)
			entity.setTable2entity(
					Table2Service.convertTable2DTOToTable2Entity(dto.getTable2dto(), !marshallTable2Stuff));
		return entity;
	}

}
