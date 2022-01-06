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
import java.sql.Timestamp;
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
public class ModelDaoImpl implements ModelDao{
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
    
    @Override
    public ModelDto getModelByid(int id) {
        try {
            final String SELECT_MODEL_BY_ID = "SELECT * FROM model WHERE id = ?";
            ModelDto model = jdbc.queryForObject(SELECT_MODEL_BY_ID, 
                    new ModelDaoMapper(), id);
            model.setManufacturer(getModelForManufacturer(model));
            return model;
        } catch(DataAccessException ex) {
            return null;
        }
    }
    
    private ManufacturerDto getModelForManufacturer(ModelDto model) {
        final String SELECT_MANUFACTURER_FOR_MODEL = "SELECT m.* FROM manufacturer m "
                + "JOIN model md ON m.id = md.make WHERE md.id = ?";
        return jdbc.queryForObject(SELECT_MANUFACTURER_FOR_MODEL, new ManufacturerMapper(), 
                model.getId());
    }
    
    @Override
    public List<ModelDto> getAllModels() {
        final String SELECT_ALL_MODELS = "SELECT * FROM model";
        List<ModelDto> models = jdbc.query(SELECT_ALL_MODELS, new ModelDaoMapper());
        
        addManufacturerToModels(models);
        
        return models;
    }
    private void addManufacturerToModels(List<ModelDto> models) {
        for(ModelDto model : models) {
            model.setManufacturer(getModelForManufacturer(model));
        }
    }
    
    @Override
    public List<ModelDto> getModelsForManufacturer(ManufacturerDto man) {
        final String SELECT_MODELS_FOR_MANUFACTURER = "SELECT * FROM model WHERE make = ?";
        List<ModelDto> models = jdbc.query(SELECT_MODELS_FOR_MANUFACTURER, 
                new ModelDaoMapper(), man.getId());
        
        addManufacturerToModels(models);
        
        return models;
    }
    
    @Override
    @Transactional
    public ModelDto addModel(ModelDto model) {
        final String INSERT_MODEL = "INSERT INTO model(modelName, trim, make) VALUES(?,?,?)";
        jdbc.update(INSERT_MODEL,
                model.getModelName(),
                model.getTrim(),
                model.getManufacturer().getId());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        model.setId(newId);
        
        return model;
    }

    @Override
    public void updateModel(ModelDto model) {
        final String UPDATE_MODEL = "UPDATE model "
                + "SET modelName = ?, trim = ?, make = ? WHERE id = ?";
        jdbc.update(UPDATE_MODEL,
                model.getModelName(),
                model.getTrim(),
                model.getManufacturer().getId(),
                model.getId());
    }
    
}

    

