package dev.abhinav.jpaPractice4.service;

import dev.abhinav.jpaPractice4.dao.Table1DAO;
import dev.abhinav.jpaPractice4.dao.Table1DAOException;
import dev.abhinav.jpaPractice4.dao.Table3DAO;
import dev.abhinav.jpaPractice4.dto.Table1DTO;
import dev.abhinav.jpaPractice4.entities.Table1Entity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Table1Service {

    @Autowired
    Table1DAO table1dao;

    @Autowired
    Table3DAO table3dao;

    public Table1DTO save(Table1DTO table1dto) throws Table1ServiceException {
        if (table1dto.getTable3dto() == null) {
            log.warn("this is not going to work. A null primary key is not allowed.");
        }
        //this works wonderfully because we are following the navigation
        Table1Entity entity = table1dao.save(convertTable1DTOToTable1Entity(table1dto));
        return convertTable1EntityToTable1DTO(entity);

    }

    public Table1DTO update(Table1DTO table1dto) throws Table1ServiceException {
        Table1Entity entity = convertTable1DTOToTable1Entity(table1dto);
        try {
            entity = table1dao.update(entity);
        } catch (Table1DAOException e) {
            e.printStackTrace();
            throw new Table1ServiceException("error updating table1 entry", e);
        }
        return convertTable1EntityToTable1DTO(entity);

    }

    public void deleteById(Long id) throws Table1ServiceException {
        table1dao.delete(id);
    }

    public Table1DTO getById(Long id) {
        return convertTable1EntityToTable1DTO(table1dao.getTable1EntityById(id));
    }

    public Table1DTO getByAttribute1(String attr1) {
        return convertTable1EntityToTable1DTO(table1dao.getTable1EntityByAttribute1(attr1).get(0));
    }

    public static Table1DTO convertTable1EntityToTable1DTO(Table1Entity entity) {
        Table1DTO dto = new Table1DTO();
        dto.setAttribute1(entity.getAttribute1());
        if (entity.getTable3() != null)
            dto.setTable3dtos(Table3Service.convertTable3EntityToTable3DTO(entity.getTable3(),false));
        dto.setId(entity.getId());
        return dto;
    }

    public static Table1Entity convertTable1DTOToTable1Entity(Table1DTO dto) {
        Table1Entity entity = new Table1Entity();
        entity.setId(dto.getId());
        entity.setAttribute1(dto.getAttribute1());
        if (dto.getTable3dto() != null)
            entity.setTable3(Table3Service.convertTable3DtoToTable3Entity(dto.getTable3dto()));
        return entity;
    }
}
