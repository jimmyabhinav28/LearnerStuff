package dev.ankita.interviewPractice1.ManyToManyBidirectional1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Table1Repository extends JpaRepository<Table1Entity, Long>{
	
	List<Table1Entity> findByAttribute1(String attribute1);
}
