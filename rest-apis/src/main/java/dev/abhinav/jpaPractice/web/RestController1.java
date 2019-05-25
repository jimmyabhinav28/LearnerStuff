package dev.abhinav.jpaPractice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.abhinav.jpaPractice.dto.Table3DTO;
import dev.abhinav.jpaPractice.service.Table3Service;
import dev.abhinav.jpaPractice.service.Table3ServiceException;

@RestController
@RequestMapping("/jpaPractice1To1")
public class RestController1 {

	@Autowired
	Table3Service table3Service;
	
	@GetMapping(path = "/getTable3RecordById/{id}")
	public Table3DTO getTable3RecordById(@PathVariable(name = "id") String id)
	{
		Table3DTO table3dto=null;
		table3dto=table3Service.getById(Long.parseLong(id));
		return table3dto;
	}
	
	@GetMapping(path = "/getTable3RecordByAttributeValue/{attribute1_value}")
	public List<Table3DTO> getTable3RecordByAttributeValue(@PathVariable(name = "attribute1_value") String attribute1Value)
	{
		List<Table3DTO> table3dtos=null;
		table3dtos=table3Service.getByAttribute1Value(attribute1Value);
		return table3dtos;
	}
	
	@DeleteMapping(path="/deleteTable3RecordById")
	public void deleteTable3RecordById(@RequestParam(name = "id",required = true)Long id)
	{
		table3Service.deleteById(id);
	}
	
	@PostMapping(path="/createTable3Record")
	public Table3DTO createNewRecord(@RequestBody Table3DTO table3Record)
	{
		return table3Service.save(table3Record);
	}
	
	@PutMapping(path = "/updateTable3Record")
	public Table3DTO updateRecord(@RequestBody Table3DTO table3Record) throws Table3ServiceException
	{
		return table3Service.update(table3Record);
	}
}
