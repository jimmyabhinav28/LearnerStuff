package dev.abhinav.jpaPractice2.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.abhinav.jpaPractice2.entities.Table1Entity;


public interface Table1Repository extends JpaRepository<Table1Entity, Long>{
	
	List<Table1Entity> findByAttribute1(String attribute1);
}
