/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.ContactInformationDto;
import com.sg.cardealership.dto.ManufacturerDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cna
 */
public class ManufacturerDaoImpl implements ManufacturerDao{
    @Autowired
    JdbcTemplate jdbc;

    
    public static final class ManufacturerMapper implements RowMapper<ManufacturerDto> {

        @Override
        public ManufacturerDto mapRow(ResultSet rs, int index) throws SQLException {
            ManufacturerDto manufacturer = new ManufacturerDto();
            manufacturer.setId(rs.getInt("id"));
            manufacturer.setManufacturerName(rs.getString("name"));
            manufacturer.setCountry(rs.getString("country"));
            return manufacturer;
        }
    }
    
    @Override
    public List<ManufacturerDto> getAllManufacturers() {
        final String SELECT_ALL_MANUFACTURERS = "SELECT * FROM manufacturer";
        return jdbc.query(SELECT_ALL_MANUFACTURERS, new ManufacturerMapper());
    }

    @Override
    public ManufacturerDto getManufacturerById(int id) {
        try {
            final String SELECT_MANUFACTURER_BY_ID = "SELECT * FROM manufacturer WHERE id = ?";
            return jdbc.queryForObject(SELECT_MANUFACTURER_BY_ID, new ManufacturerMapper(), id);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public ManufacturerDto addManufacturer(ManufacturerDto man) {
        final String INSERT_MANUFACTURER = "INSERT INTO manufacturer(name, country)"
                + "VALUES(?,?)";
        jdbc.update(INSERT_MANUFACTURER, 
                man.getManufacturerName(),
                man.getCountry());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        man.setId(newId);
        return man;
    }

    @Override
    public void updateManufacturer(ManufacturerDto man) {
        final String UPDATE_MANUFACTURER = "UPDATE manufacturer SET name = ?, country = ?"
                + "WHERE id = ?";
        jdbc.update(UPDATE_MANUFACTURER,
                man.getManufacturerName(),
                man.getCountry(),
                man.getId());
    }

    @Override
    @Transactional
    public void deleteManufacturerById(int id) {

        final String DELETE_MODEL_MANUFACTURER = "DELETE FROM model "
                + "WHERE make = ?";
        jdbc.update(DELETE_MODEL_MANUFACTURER, id);
        
        final String DELETE_MANUFACTURER = "DELETE FROM manufacturer WHERE id = ?";
        jdbc.update(DELETE_MANUFACTURER, id);
    }  
    
}
