package dev.abhinav.jpaPractice.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.abhinav.jpaPractice.dto.Table3DTO;
import dev.abhinav.jpaPractice.entities.Table3;
import dev.abhinav.jpaPractice.service.Table3Service;

@RestController
@RequestMapping("/practiceJPA")
public class Table3Controller {
	
	@Autowired
	Table3Service table3Service;
	
	@PostMapping(path = "/insertRow")
	public Table3DTO addStation(@Valid @RequestBody Table3 table3) throws Exception {
		Table3DTO table3Details = null;
		table3Details = table3Service.save(table3);
		return table3Details;

	}
	
	@GetMapping(path = "/findByAttribute/{attribute_name}")
	public Table3Response findByAttributeName(@PathVariable(name = "attribute_name") String attributeName)
			throws Exception {
		
		Table3Response table3Response = new Table3Response();
		table3Response.setData(table3Service.findByAttributeName(attributeName));
		return table3Response;
		
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable(name = "id") Long id) throws Exception{
		table3Service.deleteById(id);
	}

}
