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
        final String SELECT_ALL_CONTACTINFORMATIONS = "SELECT * FROM contactInformation";
        return jdbc.query(SELECT_ALL_CONTACTINFORMATIONS, new ManufacturerMapper());
    }

    @Override
    public ManufacturerDto getManufacturerById(int id) {
        try {
            final String SELECT_CONTACTINFORMATION_BY_ID = "SELECT * FROM contactInformation WHERE id = ?";
            return jdbc.queryForObject(SELECT_CONTACTINFORMATION_BY_ID, new ManufacturerMapper(), id);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public ManufacturerDto addManufacturer(ManufacturerDto contact) {
        final String INSERT_CONTACTINFORmaTION = "INSERT INTO contactInformation(firstName, lastName, message, email, phone) "
                + "VALUES(?,?,?,?,?)";
        jdbc.update(INSERT_CONTACTINFORmaTION, 
                contact.getFirstName(),
                contact.getLastName(),
                contact.getMessage(),
                contact.getEmail(),
                contact.getPhone());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        contact.setId(newId);
        return contact;
    }

    @Override
    public void updateManufacturer(ManufacturerDto contact) {
        final String UPDATE_CONTACTINFORMATION = "UPDATE contactInformation SET firstName = ?, lastName = ?, message = ?, email = ?, phone = ? "
                + "WHERE id = ?";
        jdbc.update(UPDATE_CONTACTINFORMATION,
                contact.getFirstName(),
                contact.getLastName(),
                contact.getMessage(),
                contact.getEmail(),
                contact.getPhone(),
                contact.getId());
    }

    @Override
    public void deleteManufacturerById(int id) {

        final String DELETE_CONTACT = "DELETE FROM contactInformation WHERE id = ?";
        jdbc.update(DELETE_CONTACT, id);
    }  
    
}
