/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.ContactInformationDto;
import com.sg.cardealership.dto.ManufacturerDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
    
}
