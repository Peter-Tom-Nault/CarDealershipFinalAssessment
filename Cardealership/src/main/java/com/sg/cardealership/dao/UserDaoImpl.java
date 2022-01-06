/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dao.AccountTypeDaoImpl.AccountTypeMapper;
import com.sg.cardealership.dto.AccountTypeDto;
import com.sg.cardealership.dto.UserDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Cna
 */
public class UserDaoImpl implements UserDao{

    @Autowired
    JdbcTemplate jdbc;     
    
    public static final class UserDaoMapper implements RowMapper<UserDto> {

        @Override
        public UserDto mapRow(ResultSet rs, int index) throws SQLException {
            UserDto user = new UserDto();
            user.setUserId(rs.getInt("userId"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    }       
    @Override
    public UserDto getUserByid(int id) {
        try {
            final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE userId = ?";
            UserDto user = jdbc.queryForObject(SELECT_USER_BY_ID, 
                    new UserDaoMapper(), id);
            user.setAccount(getAccountTypeForUser(user));
            return user;
        } catch(DataAccessException ex) {
            return null;
        }
    }
    
    private AccountTypeDto getAccountTypeForUser(UserDto user) {
        final String SELECT_ACCOUNT_FOR_USER = "SELECT a.* FROM accountTypes a "
                + "JOIN user u ON u.accountType = a.accountTypeId WHERE u.userId = ?";
        return jdbc.queryForObject(SELECT_ACCOUNT_FOR_USER, new AccountTypeMapper(), 
                user.getUserId());
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
