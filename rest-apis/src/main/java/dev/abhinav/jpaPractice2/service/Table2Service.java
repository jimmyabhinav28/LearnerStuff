package dev.abhinav.jpaPractice2.service;

import dev.abhinav.jpaPractice2.dao.Table2DAO;
import dev.abhinav.jpaPractice2.dao.Table3DAO;
import dev.abhinav.jpaPractice2.dto.Table2DTO;
import dev.abhinav.jpaPractice2.dto.Table3DTO;
import dev.abhinav.jpaPractice2.entities.Table2Entity;
import dev.abhinav.jpaPractice2.entities.Table3Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Table2Service {
	@Autowired
	Table2DAO table2dao;

	@Autowired
	Table3DAO table3dao;


	public Table2DTO getById(Long id) {

		return convertTable2EntityToTable2DTO(table2dao.getById(id));
	}

	public Table2DTO save(Table2DTO table2dto) throws Table2ServiceException {
		Table2Entity entity = table2dao.save(convertTable2DTOToTable2Entity(table2dto));
		return convertTable2EntityToTable2DTO(entity);
	}

	public Table2DTO update(Table2DTO table2dto) throws Table2ServiceException {
		Table2Entity entity = convertTable2DTOToTable2Entity(table2dto);
		entity = table2dao.update(entity);
		return convertTable2EntityToTable2DTO(entity);

	}

	public void deleteById(Long id) throws Table2ServiceException {
		table2dao.delete(id);
	}

	public static Table2DTO convertTable2EntityToTable2DTO(Table2Entity entity) {
		Table2DTO dto = new Table2DTO();
		dto.setId(entity.getId());
		dto.setAttribute1(entity.getAttribute1());
		if (entity.getTable3() != null) {
			dto.setTable3dto(
					Table3Service.convertTable3EntityToTable3DTO(entity.getTable3(), dto));

		}
		return dto;
	}

	public static Table2DTO convertTable2EntityToTable2DTO(Table2Entity entity, Table3DTO table3DTO) {

		Table2DTO dto = new Table2DTO();
		dto.setId(entity.getId());
		dto.setAttribute1(entity.getAttribute1());
		if (table3DTO != null) {
			dto.setTable3dto(table3DTO);

		}
		return dto;
	}


	public static Table2Entity convertTable2DTOToTable2Entity(Table2DTO dto) {
		Table2Entity entity = new Table2Entity();
		entity.setId(dto.getId());
		entity.setAttribute1(dto.getAttribute1());
		if (dto.getTable3dto() != null) {
			entity.setTable3(
					Table3Service.convertTable3DtoToTable3Entity(dto.getTable3dto(), entity));
		}
		return entity;
	}

	public static Table2Entity convertTable2DTOToTable2Entity(Table2DTO dto, Table3Entity table3Entity) {
		Table2Entity entity = new Table2Entity();
		entity.setId(dto.getId());
		entity.setAttribute1(dto.getAttribute1());
		if (table3Entity != null) {
			entity.setTable3(table3Entity);
		}
		return entity;

	}


}
