package dev.abhinav.jpaPractice2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.abhinav.jpaPractice2.entities.Table1Entity;
import dev.abhinav.jpaPractice2.service.Table1Repository;

@Component
public class Table1DAO {
	@Autowired
	Table1Repository table1Repository;
	
	public Table1Entity getTable1EntityById(Long id)
	{
		return table1Repository.getOne(id);
	}
	
	public List<Table1Entity> getTable1EntityByAttribute1(String attribute1Value)
	{
		List<Table1Entity> entities= table1Repository.findByAttribute1(attribute1Value);
		return entities;
//		for(Table1Entity entity: entities)
			
	}

}
