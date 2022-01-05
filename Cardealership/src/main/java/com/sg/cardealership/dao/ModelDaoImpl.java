/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dao.ManufacturerDaoImpl.ManufacturerMapper;
import com.sg.cardealership.dto.ManufacturerDto;
import com.sg.cardealership.dto.ModelDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Cna
 */
public class ModelDaoImpl {
    @Autowired
    static JdbcTemplate jdbc;
    
    public static final class ModelDaoMapper implements RowMapper<ModelDto> {

        @Override
        public ModelDto mapRow(ResultSet rs, int index) throws SQLException {
            ModelDto model = new ModelDto();
            model.setId(rs.getInt("id"));
            model.setModelName(rs.getString("modelName"));
            model.setTrim(rs.getString("trim"));            
            model.setManufacturer(getManufacturerForModel(rs.getInt("make")));
            return model;
        }
    } 
    
    private static ManufacturerDto getManufacturerForModel(int ManufacturerId) {
        final String SELECT_MANUFACTURER_FOR_MODEL = "SELECT m.* FROM manufacturer m WHERE m.id = ?";
        return jdbc.queryForObject(SELECT_MANUFACTURER_FOR_MODEL, new ManufacturerMapper(), 
                ManufacturerId);
    }
    
}