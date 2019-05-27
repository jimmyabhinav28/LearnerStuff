package dev.abhinav.jpaPractice2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.abhinav.jpaPractice2.dao.Table2DAO;
import dev.abhinav.jpaPractice2.dao.Table2DAOException;
import dev.abhinav.jpaPractice2.dao.Table3DAO;
import dev.abhinav.jpaPractice2.dto.Table2DTO;
import dev.abhinav.jpaPractice2.dto.Table3DTO;
import dev.abhinav.jpaPractice2.entities.Table2Entity;
import dev.abhinav.jpaPractice2.entities.Table3Entity;

@Component
public class Table2Service {
	@Autowired
	Table2DAO table2dao;
	
	@Autowired
	Table3DAO table3dao;
	
	public Table2DTO getById(Long id)
	{
		return convertTable2EntityToTable2DTO(table2dao.getById(id),true);
	}
	
	public Table2DTO save(Table2DTO table2dto) throws Table2ServiceException
	{
		//since table 2 is child, table 2 record can exist without table3 record if table3_id is nullable 
		//the problem though is that we have a mapsId case here and we have made the foreign key as the primary key
		//hence table3_id is not nullable
		//the way to go about, hence will be to get a table3DTO from the table2DTO and save it
		/*
		 * Table3DTO table3dto=table2dto.getTable3dto(); if(table3dto==null) throw new
		 * Table2ServiceException("cannot store a table3 entity without a table 3 entity"
		 * ); Table3Entity
		 * table3Entity=Table3Service.convertTable3DtoToTable3Entity(table3dto, true);
		 * table3Entity=table3dao.save(table3Entity); return
		 * convertTable2EntityToTable2DTO(table3Entity.getTable2entity(), true);
		 */
		Table2Entity entity=table2dao.save(convertTable2DTOToTable2Entity(table2dto, true));
		return convertTable2EntityToTable2DTO(entity, true);
	}

	public Table2DTO update(Table2DTO table2dto) throws Table2ServiceException
	{
		//update is not trivial
		//you will have to see if you want to change the mapping of the table2 entity with the table 3 entity
		//there are a lot of things to consider here...more on that later...i think jpa does not allow you to change the primary key of a record while updating
		//as of now we are not considering a change in primary key
		Table2Entity entity=convertTable2DTOToTable2Entity(table2dto, true);
		entity=table2dao.update(entity);
		return convertTable2EntityToTable2DTO(entity, true);
		
	}
	
	public void deleteById(Long id) throws Table2ServiceException
	{
		table2dao.delete(id);
	}
	public static Table2DTO convertTable2EntityToTable2DTO(Table2Entity entity, boolean marshallTable3stuff) {
		Table2DTO dto = new Table2DTO();
		dto.setId(entity.getId());
		dto.setAttribute1(entity.getAttribute1());
		if (entity.getTable3() != null && marshallTable3stuff) {
				dto.setTable3dto(
						Table3Service.convertTable3EntityToTable3DTO(entity.getTable3(), !marshallTable3stuff));

		}
		return dto;
	}

	public static Table2Entity convertTable2DTOToTable2Entity(Table2DTO dto, boolean marshallTable3stuff) {
		Table2Entity entity = new Table2Entity();
		entity.setId(dto.getId());
		entity.setAttribute1(dto.getAttribute1());
		if (dto.getTable3dto() != null && marshallTable3stuff) {
				entity.setTable3(
						Table3Service.convertTable3DtoToTable3Entity(dto.getTable3dto(), !marshallTable3stuff));
		}
		return entity;
	}

}
