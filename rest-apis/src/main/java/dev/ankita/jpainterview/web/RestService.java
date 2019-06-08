package dev.ankita.jpainterview.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ankita.jpainterview.entities.Table1;
import dev.ankita.jpainterview.service.Table1Service;

@RestController
@RequestMapping("/practiceJPA/onetomanybidirectional")
public class RestService {
	
	@Autowired
	Table1Service table1Service;
	
	
	@GetMapping(path = "/findByAttribute/{attribute_name}")
	public List<Table1> findByAttribute1(@PathVariable(name = "attribute_name") String attributeName) {
		List<Table1> table1List = new ArrayList<Table1>();
		table1List = table1Service.findByAttribute1(attributeName);
		return table1List;
		
	}
	

}
