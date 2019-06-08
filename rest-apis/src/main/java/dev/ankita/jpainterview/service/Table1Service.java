package dev.ankita.jpainterview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ankita.jpainterview.entities.Table1;

@Service
public class Table1Service {
	@Autowired 
	Table1Repository table1Repository;
	
	public List<Table1> findByAttribute1(String attributeName){
		
		List<Table1> table1 = null;
		table1 = table1Repository.findByAttribute1(attributeName);
		return table1;
	}

}
