package dev.abhinav.jpaPractice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.abhinav.jpaPractice.entities.Table3;
import dev.abhinav.metro.dao.StationNotFoundException;
import dev.abhinav.metro.entities.Station;

@Component
public class Table3DAO {
	
	@Autowired 
	Table3Repository table3Repository;
	
	public Table3 findByAttributeName(String attributeName) throws Table3NotFoundException {
		List<Table3> table3 = null;
		try {
			table3 = table3Repository.findByAttribute1(attributeName);
			if (table3 == null || table3.isEmpty())
			{
				return null;
			}
		} catch (Exception e) {
			String msg="Table3 is null!";
			throw new Table3NotFoundException(msg,e);
		}
		return table3.get(0);
		
	}
	
	 public void deleteById(Long id) throws Table3NotFoundException { 
		 try {
			 table3Repository.deleteById(id);
		 }catch (Exception e) {
			String msg="Table3 is null!";
			throw new Table3NotFoundException(msg,e);
		}
		 
	 }
	 
	 public Table3 save(Table3 table3)
		{
			return table3Repository.save(table3);
		}

}
