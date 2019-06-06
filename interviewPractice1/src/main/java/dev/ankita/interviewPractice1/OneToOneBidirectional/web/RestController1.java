package dev.ankita.interviewPractice1.OneToOneBidirectional.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.ankita.interviewPractice1.OneToOneBidirectional.dao.Table1DAO;
import dev.ankita.interviewPractice1.OneToOneBidirectional.dao.Table1DAOException;
import dev.ankita.interviewPractice1.OneToOneBidirectional.dao.Table1Entity;
import dev.ankita.interviewPractice1.OneToOneBidirectional.dao.Table2DAO;
import dev.ankita.interviewPractice1.OneToOneBidirectional.dao.Table2DAOException;
import dev.ankita.interviewPractice1.OneToOneBidirectional.dao.Table2Entity;
import dev.ankita.interviewPractice1.OneToOneBidirectional.dao.Table3DAO;
import dev.ankita.interviewPractice1.OneToOneBidirectional.dao.Table3DAOException;
import dev.ankita.interviewPractice1.OneToOneBidirectional.dao.Table3Entity;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestController1 {


		@Autowired
		 Table1DAO table1dao;

		@Autowired
		Table2DAO table2dao;
		
		@Autowired
		Table3DAO table3dao;
		
		@GetMapping(path = "/getTable1RecordById/{id}")
		public Table1Entity getTable1RecordById(@PathVariable(name = "id") String id) {
			Table1Entity result=null;
			result = table1dao.getTable1EntityById(Long.parseLong(id));
			return result;
		}

		@GetMapping(path = "/getTable2RecordById/{id}")
		public Table2Entity getTable2RecordById(@PathVariable(name = "id") String id) {
			Table2Entity result = null;
			result = table2dao.getById(Long.parseLong(id));
			return result;
		}

		@GetMapping(path = "/getTable3RecordById/{id}")
		public Table3Entity getTable3RecordById(@PathVariable(name = "id") String id) {
			Table3Entity result = null;
			result = table3dao.getById(Long.parseLong(id));
			return result;
		}

		@DeleteMapping(path = "/deleteTable1RecordById")
		public void deleteTable1RecordById(@RequestParam(name = "id", required = true) Long id)
				throws Table1DAOException {
			table1dao.delete(id);
		}

		@PostMapping(path = "/createTable1Record")
		public Table1Entity createNewRecordTable1(@RequestBody Table1Entity table1Record) throws Table1DAOException {
			return table1dao.save(table1Record);
		}

		@PutMapping(path = "/updateTable1Record")
		public Table1Entity updateRecord(@RequestBody Table1Entity table1Record) throws Table1DAOException {
			return table1dao.update(table1Record);
		}

		@DeleteMapping(path = "/deleteTable2RecordById")
		public void deleteTable2RecordById(@RequestParam(name = "id", required = true) Long id)
				throws Table2DAOException {
			table2dao.delete(id);
		}

		@PostMapping(path = "/createTable2Record")
		public Table2Entity createNewRecordTable2(@RequestBody Table2Entity table2Record) throws Table2DAOException {
			return table2dao.save(table2Record);
		}

		@PutMapping(path = "/updateTable2Record")
		public Table2Entity updateRecord(@RequestBody Table2Entity table2Record) throws Table2DAOException {
			return table2dao.save(table2Record);
			}

		@DeleteMapping(path = "/deleteTable3RecordById")
		public void deleteTable3RecordById(@RequestParam(name = "id", required = true) Long id) {
			table3dao.deleteById(id);
		}

		@PostMapping(path = "/createTable3Record")
		public Table3Entity createNewRecord(@RequestBody Table3Entity table3Record) {
			return table3dao.save(table3Record);
		}

		@PutMapping(path = "/updateTable3Record")
		public Table3Entity updateRecord(@RequestBody Table3Entity table3Record) throws Table3DAOException {
			return table3dao.update(table3Record);
		}
}
