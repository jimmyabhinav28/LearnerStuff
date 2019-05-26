package dev.abhinav.jpaPractice2.web;

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
import dev.abhinav.jpaPractice2.service.Table3Service;
import dev.abhinav.jpaPractice2.service.Table1Service;
import dev.abhinav.jpaPractice2.service.Table2Service;
import dev.abhinav.jpaPractice.service.Table3ServiceException;
import dev.abhinav.jpaPractice2.dto.Table1DTO;

@RestController
@RequestMapping("/jpaPractice1To1")
public class RestController2 {

	@Autowired
	Table3Service table3Service;
	
	@Autowired
	Table2Service table2Service;
	
	@Autowired
	Table1Service table1Service;
	
	@GetMapping(path = "/getTable1RecordById/{id}")
	public Table1DTO getTable1RecordById(@PathVariable(name = "id") String id)
	{
		Table1DTO table1dto=null;
		table1dto=table1Service.getById(Long.parseLong(id));
		return table1dto;
	}
	
	@GetMapping(path = "/getTable3RecordByAttributeValue/{attribute1_value}")
	public Table1DTO getTable3RecordByAttributeValue(@PathVariable(name = "attribute1_value") String attribute1Value)
	{
		Table1DTO table1dto=null;
		table1dto=table1Service.getByAttribute1(attribute1Value);
		return table1dto;
	}
	
//	@DeleteMapping(path="/deleteTable3RecordById")
//	public void deleteTable3RecordById(@RequestParam(name = "id",required = true)Long id)
//	{
//		table3Service.deleteById(id);
//	}
//	
//	@PostMapping(path="/createTable3Record")
//	public Table3DTO createNewRecord(@RequestBody Table3DTO table3Record)
//	{
//		return table3Service.save(table3Record);
//	}
//	
//	@PutMapping(path = "/updateTable3Record")
//	public Table3DTO updateRecord(@RequestBody Table3DTO table3Record) throws Table3ServiceException
//	{
//		return table3Service.update(table3Record);
//	}
}
