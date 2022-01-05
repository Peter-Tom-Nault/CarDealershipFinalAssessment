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
    JdbcTemplate jdbc;
    
    public static final class ModelDaoMapper implements RowMapper<ModelDto> {

        @Override
        public ModelDto mapRow(ResultSet rs, int index) throws SQLException {
            ModelDto model = new ModelDto();
            model.setId(rs.getInt("id"));
            model.setModelName(rs.getString("modelName"));
            model.setTrim(rs.getString("trim"));            
            return model;
        }
    } 
    
    
}
