package dev.ankita.jpainterview.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ankita.jpainterview.entities.Table1;

public interface Table1Repository  extends JpaRepository<Table1,Long>{
	
	
	List<Table1> findByAttribute1(String attribute1);

}
