package dev.abhinav.jpaPractice2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.abhinav.jpaPractice2.entities.Table2Entity;
import dev.abhinav.jpaPractice2.entities.Table3Entity;
import dev.abhinav.jpaPractice2.service.Table2Repository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Table2DAO {
@Autowired
Table2Repository table2Repository;

public Table2Entity getById(Long id)
{
	return table2Repository.getOne(id);
}

public void delete(Long id)
{
	log.info("trying to delete table 2 record with id "+id);
	table2Repository.deleteById(id);
}

public Table2Entity update(Table2Entity entity)
{
	Table2Entity storedEntity=getById(entity.getId());
	storedEntity.setAttribute1(entity.getAttribute1());
	return table2Repository.save(storedEntity);
}
}
