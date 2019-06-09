package dev.ankita.interviewPractice1.ManyToManyBidirectional1.web;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.ankita.interviewPractice1.ManyToManyBidirectional1.dao.Table1DAO;
import dev.ankita.interviewPractice1.ManyToManyBidirectional1.dao.Table1DAOException;
import dev.ankita.interviewPractice1.ManyToManyBidirectional1.dao.Table1Entity;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestControllerManyToManyBidirectional1 {

	@Autowired
	Table1DAO table1Dao;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping(path="/interviewPractice1/ManyToManyBidirectional1/getTable1Record/{id}")
	public Table1Entity getTable1RecordById(@PathVariable(name = "id") Long id)
	{
		Table1Entity result=null;
		result=table1Dao.getTable1EntityById(id);
		return result;
		//return modelMapper.map(result,Table1DTO.class);
	}
	
	@PostMapping(path="/interviewPractice1/ManyToManyBidirectional1/createTable1Record")
	public Table1Entity createTable1Record(@Valid @RequestBody Table1Entity requestBody)
	{
		Table1Entity result=null;
		result=table1Dao.save(requestBody);
		return getTable1RecordById(result.getId());
	}
	
	@PutMapping(path="/interviewPractice1/ManyToManyBidirectional1/updateTable1Record")
	public Table1Entity updateTable1Record(@Valid @RequestBody Table1Entity requestBody) throws Table1DAOException
	{
		Table1Entity result=null;
		result=table1Dao.update(requestBody);
		return getTable1RecordById(result.getId());
	}
	
	@DeleteMapping(path="/interviewPractice1/ManyToManyBidirectional1/deleteTable1Record/{id}")
	public void delteTable1RecordById(@PathVariable(name = "id") Long id)
	{
		table1Dao.delete(id);
	}
	
}
