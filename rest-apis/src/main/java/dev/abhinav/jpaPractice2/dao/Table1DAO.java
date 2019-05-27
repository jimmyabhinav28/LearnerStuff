package dev.abhinav.jpaPractice2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.abhinav.jpaPractice2.dto.Table1DTO;
import dev.abhinav.jpaPractice2.dto.Table3DTO;
import dev.abhinav.jpaPractice2.entities.Table1Entity;
import dev.abhinav.jpaPractice2.entities.Table1Entity;
import dev.abhinav.jpaPractice2.entities.Table3Entity;
import dev.abhinav.jpaPractice2.service.Table1Repository;
import dev.abhinav.jpaPractice2.service.Table3Service;

@Component
public class Table1DAO {
	@Autowired
	Table1Repository table1Repository;

	public Table1Entity getTable1EntityById(Long id) {
		return table1Repository.getOne(id);
	}
	
	public Table1Entity save(Table1Entity entity)
	{
		return table1Repository.save(entity);
	}

	public List<Table1Entity> getTable1EntityByAttribute1(String attribute1Value) {
		List<Table1Entity> entities = table1Repository.findByAttribute1(attribute1Value);
		return entities;
//		for(Table1Entity entity: entities)

	}

	public Table1Entity update(Table1Entity entity) throws Table1DAOException {
		if(entity.getId()==null)
			throw new Table1DAOException("id cannot be null for update");
		return table1Repository.save(entity);
	}

	public void delete(Long id) {
		table1Repository.deleteById(id);
		
	}

}
