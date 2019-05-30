package dev.abhinav.jpaPractice3.dao;

import dev.abhinav.jpaPractice3.entities.Table2Entity;
import dev.abhinav.jpaPractice3.service.Table2Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Table2DAO {
	@Autowired
    Table2Repository table2Repository;

	public Table2Entity getById(Long id) {
		return table2Repository.getOne(id);
	}

	public void delete(Long id) {
		log.info("trying to delete table 2 record with id " + id);
		table2Repository.deleteById(id);
	}

	/*
	 * public Table2Entity update(Table2Entity entity) { Table2Entity storedEntity =
	 * getById(entity.getId()); storedEntity.setAttribute1(entity.getAttribute1());
	 * return table2Repository.save(storedEntity); }
	 */

	public Table2Entity update(Table2Entity entity) {
		return table2Repository.save(entity);
	}

	public Table2Entity save(Table2Entity entity) {
		return table2Repository.save(entity);
	}
}
