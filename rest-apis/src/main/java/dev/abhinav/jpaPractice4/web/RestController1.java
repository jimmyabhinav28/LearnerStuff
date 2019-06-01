package dev.abhinav.jpaPractice4.web;

import dev.abhinav.jpaPractice4.dto.Table1DTO;
import dev.abhinav.jpaPractice4.dto.Table2DTO;
import dev.abhinav.jpaPractice4.dto.Table3DTO;
import dev.abhinav.jpaPractice4.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jpaPractice1To1")
public class RestController1 {

	@Autowired
    Table3Service table3Service;

	@Autowired
    Table2Service table2Service;

	@Autowired
    Table1Service table1Service;

	@GetMapping(path = "/getTable1RecordById/{id}")
	public Table1DTO getTable1RecordById(@PathVariable(name = "id") String id) {
		Table1DTO table1dto = null;
		table1dto = table1Service.getById(Long.parseLong(id));
		return table1dto;
	}

	@GetMapping(path = "/getTable2RecordById/{id}")
	public Table2DTO getTable2RecordById(@PathVariable(name = "id") String id) {
		Table2DTO table2dto = null;
		table2dto = table2Service.getById(Long.parseLong(id));
		return table2dto;
	}

	@GetMapping(path = "/getTable3RecordById/{id}")
	public Table3DTO getTable3RecordById(@PathVariable(name = "id") String id) {
		Table3DTO table3dto = null;
		table3dto = table3Service.getById(Long.parseLong(id));
		return table3dto;
	}

	@GetMapping(path = "/getTable3RecordByAttributeValue/{attribute1_value}")
	public Table1DTO getTable3RecordByAttributeValue(@PathVariable(name = "attribute1_value") String attribute1Value) {
		Table1DTO table1dto = null;
		table1dto = table1Service.getByAttribute1(attribute1Value);
		return table1dto;
	}

	@DeleteMapping(path = "/deleteTable1RecordById")
	public void deleteTable1RecordById(@RequestParam(name = "id", required = true) Long id)
			throws Table1ServiceException {
		table1Service.deleteById(id);
	}

	@PostMapping(path = "/createTable1Record")
	public Table1DTO createNewRecordTable1(@RequestBody Table1DTO table1Record) throws Table1ServiceException {
		return table1Service.save(table1Record);
	}

	@PutMapping(path = "/updateTable1Record")
	public Table1DTO updateRecord(@RequestBody Table1DTO table1Record) throws Table1ServiceException {
		return table1Service.update(table1Record);
	}

	@DeleteMapping(path = "/deleteTable2RecordById")
	public void deleteTable2RecordById(@RequestParam(name = "id", required = true) Long id)
			throws Table2ServiceException {
		table2Service.deleteById(id);
	}

	@PostMapping(path = "/createTable2Record")
	public Table2DTO createNewRecordTable2(@RequestBody Table2DTO table2Record) throws Table2ServiceException {
		return table2Service.save(table2Record);
	}

	@PutMapping(path = "/updateTable2Record")
	public Table2DTO updateRecord(@RequestBody Table2DTO table2Record) throws Table2ServiceException {
		return table2Service.update(table2Record);
	}

	@DeleteMapping(path = "/deleteTable3RecordById")
	public void deleteTable3RecordById(@RequestParam(name = "id", required = true) Long id) {
		table3Service.deleteById(id);
	}

	@PostMapping(path = "/createTable3Record")
	public Table3DTO createNewRecord(@RequestBody Table3DTO table3Record) {
		return table3Service.save(table3Record);
	}

	@PutMapping(path = "/updateTable3Record")
	public Table3DTO updateRecord(@RequestBody Table3DTO table3Record) throws Table3ServiceException {
		return table3Service.update(table3Record);
	}
}
