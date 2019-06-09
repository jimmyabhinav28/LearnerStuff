package dev.ankita.interviewPractice1.ManyToManyBidirectional1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface Table3Repository extends JpaRepository<Table3Entity, Long>{
	
	@Query("select s from Table3Entity s where s.attribute1=?1")
	List<Table3Entity> getByAttribute1Value(String attribute1Value);

}
