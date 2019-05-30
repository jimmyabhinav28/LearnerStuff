package dev.abhinav.jpaPractice3.service;

import dev.abhinav.jpaPractice3.dao.Table1DAO;
import dev.abhinav.jpaPractice3.dao.Table3DAO;
import dev.abhinav.jpaPractice3.dao.Table3DAOException;
import dev.abhinav.jpaPractice3.dto.Table2DTO;
import dev.abhinav.jpaPractice3.dto.Table3DTO;
import dev.abhinav.jpaPractice3.entities.Table2Entity;
import dev.abhinav.jpaPractice3.entities.Table3Entity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class Table3Service {

	@Autowired
    Table3DAO table3DAO;
	@Autowired
    Table1DAO table1DAO;

	public Table3DTO save(Table3DTO table3dto) {
		Table3Entity entity = convertTable3DtoToTable3Entity(table3dto);
		entity = table3DAO.save(entity);
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

	public List<Table3DTO> getByAttribute1Value(String attribute1Value) {
		List<Table3DTO> table3dtos = new ArrayList<Table3DTO>();
		List<Table3Entity> entities = table3DAO.getByAttribute1Value(attribute1Value);
		for (Table3Entity entity : entities) {
			Table3DTO dto = convertTable3EntityToTable3DTO(entity,true);
			table3dtos.add(dto);
		}
		return table3dtos;
	}

	public Table3DTO getById(Long id) {
		Table3DTO dto = null;
		Table3Entity entity = table3DAO.getById(id);
		log.info("number of related entities "+entity.getTable2Entities().size());
		Set<Table2Entity> table2Entities=entity.getTable2Entities();
		Set<Table2DTO> table2DTOS=new HashSet<>();
		for(Table2Entity table2Entity: table2Entities)
		{
			table2DTOS.add(Table2Service.convertTable2EntityToTable2DTO(table2Entity,null));
		}
		dto = convertTable3EntityToTable3DTO(entity,table2DTOS);
		return dto;
	}

	public Table3DTO update(Table3DTO dto) throws Table3ServiceException {
		Table3Entity entity = convertTable3DtoToTable3Entity(dto);
		try {
			entity = table3DAO.update(entity);
		} catch (Table3DAOException e) {
			e.printStackTrace();
			throw new Table3ServiceException("error updating table3 record", e);
		}
		return convertTable3EntityToTable3DTO(entity,true);
	}

	public static Table3DTO convertTable3EntityToTable3DTO(Table3Entity entity,boolean convertTable2EntitiesToDTOs) {
		Table3DTO dto = new Table3DTO();
		dto.setAttribute1(entity.getAttribute1());
		dto.setId(entity.getId());
		if (entity.getTable2Entities() != null && convertTable2EntitiesToDTOs) {
			dto.setTable2DTOS(new HashSet<>());
			for(Table2Entity table2Entity: entity.getTable2Entities()) {
				dto.getTable2DTOS().add(
						Table2Service.convertTable2EntityToTable2DTO(table2Entity, dto));
			}
		}
		return dto;
	}


	public static Table3DTO convertTable3EntityToTable3DTO(Table3Entity entity, Table2DTO table2DTO) {
		Table3DTO dto = new Table3DTO();
		dto.setAttribute1(entity.getAttribute1());
		dto.setId(entity.getId());
		if (table2DTO != null) {
			dto.setTable2DTOS(new HashSet<>());
			dto.getTable2DTOS().add(table2DTO);
		}
		return dto;
	}

	public static Table3DTO convertTable3EntityToTable3DTO(Table3Entity entity, Set<Table2DTO> table2DTOs) {
		Table3DTO dto = new Table3DTO();
		dto.setAttribute1(entity.getAttribute1());
		dto.setId(entity.getId());
		if (table2DTOs != null) {
			dto.setTable2DTOS(table2DTOs);
		}
		return dto;
	}


	public static Table3Entity convertTable3DtoToTable3Entity(Table3DTO dto, Set<Table2Entity> table2Entities) {
		Table3Entity entity = new Table3Entity();
		entity.setAttribute1(dto.getAttribute1());
		entity.setId(dto.getId());
		if (table2Entities!= null)
			entity.setTable2Entities(table2Entities);
		return entity;
	}

	public static Table3Entity convertTable3DtoToTable3Entity(Table3DTO dto, Table2Entity table2Entity) {
		Table3Entity entity = new Table3Entity();
		entity.setAttribute1(dto.getAttribute1());
		entity.setId(dto.getId());
		if (table2Entity!= null) {
			entity.setTable2Entities(new HashSet<Table2Entity>());
			entity.getTable2Entities().add(table2Entity);
		}
		return entity;
	}


	public static Table3Entity convertTable3DtoToTable3Entity(Table3DTO dto) {
		Table3Entity entity = new Table3Entity();
		entity.setAttribute1(dto.getAttribute1());
		entity.setId(dto.getId());
		if (dto.getTable2DTOS() != null) {
			entity.setTable2Entities(new HashSet<Table2Entity>());
			for (Table2DTO table2DTO : dto.getTable2DTOS())
				entity.getTable2Entities().add(Table2Service.convertTable2DTOToTable2Entity(table2DTO, entity));
		}
		return entity;
	}
}


