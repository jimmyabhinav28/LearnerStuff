package dev.ankita.interviewPractice1.OneToOneBidirectional.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Table1Repository extends JpaRepository<Table1Entity, Long>{
	
	List<Table1Entity> findByAttribute1(String attribute1);
}
