package dev.abhinav.jpaPractice1.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.abhinav.jpaPractice1.entities.Table3Entity;


public interface Table3Repository extends JpaRepository<Table3Entity, Long>{
	
	@Query("select s from Table3Entity s where s.attribute1=?1")
	List<Table3Entity> getByAttribute1Value(String attribute1Value);

}
