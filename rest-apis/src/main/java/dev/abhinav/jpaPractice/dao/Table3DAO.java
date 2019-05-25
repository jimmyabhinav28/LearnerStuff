package dev.abhinav.jpaPractice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.abhinav.jpaPractice.entities.Table3Entity;
import dev.abhinav.jpaPractice.service.Table3Repository;

@Component
public class Table3DAO {


	@Autowired
	Table3Repository table3Repository;
	
	public Table3Entity save(Table3Entity table3Entity)
	{
		return table3Repository.save(table3Entity);
	}
	
	public void deleteByAttribute1(String attribute1Value)
	{
		List<Table3Entity> table3Entities= table3Repository.getByAttribute1Value(attribute1Value);
		for(Table3Entity entity: table3Entities)
		{
			table3Repository.delete(entity);
		}
	}
	
	public void deleteById(Long id)
	{
		 table3Repository.deleteById(id);
	}
	
	public List<Table3Entity> getByAttribute1Value(String attribute1Value)
	{
		return table3Repository.getByAttribute1Value(attribute1Value);
	}
	
	public Table3Entity getById(Long id)
	{
		return table3Repository.getOne(id);
	}
	
	public Table3Entity update(Table3Entity entity) throws Table3DAOException
	{
		if(entity.getId()==null)
			throw new Table3DAOException("no id supplied for entity to update");
		Table3Entity storedEntity=table3Repository.getOne(entity.getId());
		storedEntity.setAttribute1(entity.getAttribute1());
		storedEntity.setTable1Entity(entity.getTable1Entity());
		storedEntity.setTable2Entity(entity.getTable2Entity());
		storedEntity=table3Repository.save(storedEntity);
		return storedEntity;
	}


}
