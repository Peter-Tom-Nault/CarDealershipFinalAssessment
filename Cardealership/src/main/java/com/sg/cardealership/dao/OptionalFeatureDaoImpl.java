/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.ManufacturerDto;
import com.sg.cardealership.dto.OptionalFeatureDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Cna
 */
public class OptionalFeatureDaoImpl implements OptionalFeatureDao{
    
    public static final class OptionalFeatureMapper implements RowMapper<OptionalFeatureDto> {

        @Override
        public OptionalFeatureDto mapRow(ResultSet rs, int index) throws SQLException {
            OptionalFeatureDto optional = new OptionalFeatureDto();
            optional.setFeatureId(rs.getInt("featureId"));
            optional.setName(rs.getString("name"));
            return optional;
        }
    }      
}
