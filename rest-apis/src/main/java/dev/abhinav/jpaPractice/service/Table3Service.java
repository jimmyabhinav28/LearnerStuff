package dev.abhinav.jpaPractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.abhinav.jpaPractice.dao.Table3DAO;
import dev.abhinav.jpaPractice.dto.Table3DTO;
import dev.abhinav.jpaPractice.entities.Table3;
import dev.abhinav.jpaPractice.entities.Table2;
import dev.abhinav.jpaPractice.entities.Table1;




@Service
public class Table3Service {
	
	@Autowired
	Table3DAO table3DAO;
	
	public Table3DTO findByAttributeName(String attributeName) throws Exception
	{
		return new Table3DTO(table3DAO.findByAttributeName(attributeName));
	}
	
	
	public void deleteById(Long id) throws Exception { 
		table3DAO.deleteById(id);
	}
	
	public Table3DTO save(Table3 table3) {
		Table3 tab3 = new Table3();
		if(table3 !=null) {
			Long i=(long) 0;
			tab3.setId(table3.getId());
			tab3.setAttribute1(table3.getAttribute1());
			i++;
		}
		if(table3.getTable2() != null) {
			Long i=(long) 0;
			Table2 table2 = new Table2();
			table2.setId(table3.getTable2().getId());
			table2.setAttribute1(table3.getTable2().getAttribute1());
			i++;
			table3.setTable2(table2);
		}
		if(table3.getTable1() != null) {
			Long i=(long) 0;
			Table1 table1 = new Table1();
			table1.setId(table3.getTable1().getId());
			table1.setAttribute1(table3.getTable1().getAttribute1());
			i++;
			table3.setTable1(table1);
		}
		
		table3DAO.save(table3);
		return new Table3DTO(table3);
		
	}

}
