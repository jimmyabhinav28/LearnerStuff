package dev.ankita.jpainterview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ankita.jpainterview.entities.Table3;

@Service
public class Table3Service {
	@Autowired 
	Table3Repository table3Repository;
	
	public List<Table3> findByAttribute1(String attributeName){
		
		List<Table3> table3 = null;
		table3 = table3Repository.findByAttribute1(attributeName);
		return table3;
	}

}
