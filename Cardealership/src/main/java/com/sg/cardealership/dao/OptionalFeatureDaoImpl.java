/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.OptionalFeatureDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cna
 */
@Repository
public class OptionalFeatureDaoImpl implements OptionalFeatureDao{
    
    JdbcTemplate jdbc;
    
    @Autowired
    public OptionalFeatureDaoImpl(JdbcTemplate jdbc)
    {
        this.jdbc = jdbc;
    }
    
    public static final class OptionalFeatureMapper implements RowMapper<OptionalFeatureDto> {

        @Override
        public OptionalFeatureDto mapRow(ResultSet rs, int index) throws SQLException {
            OptionalFeatureDto optional = new OptionalFeatureDto();
            optional.setFeatureId(rs.getInt("featureId"));
            optional.setName(rs.getString("name"));
            return optional;
        }
    }
    
    @Override
    public List<OptionalFeatureDto> getAllOptionalFeatures() {
        final String SELECT_ALL_OPTIONALFEATURES = "SELECT * FROM optionalfeature";
        return jdbc.query(SELECT_ALL_OPTIONALFEATURES, new OptionalFeatureMapper());
    }

    @Override
    public OptionalFeatureDto getOptionalFeatureById(int id) {
        try {
            final String SELECT_OPTIONALFEATURE_BY_ID = "SELECT * FROM optionalfeature WHERE featureId = ?";
            return jdbc.queryForObject(SELECT_OPTIONALFEATURE_BY_ID, new OptionalFeatureMapper(), id);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public OptionalFeatureDto addOptionalFeature(OptionalFeatureDto option) {
        final String INSERT_OPTIONALFEATURE = "INSERT INTO optionalFeature(name) "
                + "VALUES(?)";
        jdbc.update(INSERT_OPTIONALFEATURE, 
                option.getName());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        option.setFeatureId(newId);
        return option;
    }
    

    @Override
    public void updateOptionalFeature(OptionalFeatureDto option) {
        final String UPDATE_OPTIONALFEATURE = "UPDATE optionalFeature SET name = ?"
                + "WHERE id = ?";
        jdbc.update(UPDATE_OPTIONALFEATURE,
                option.getName(),
                option.getFeatureId());
    }
    
}

