/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.UserDto;
import com.sg.cardealership.dto.VehicleDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Cna
 */
public class VehicleDaoImpl implements VehicleDao{
    public static final class VehicleMapper implements RowMapper<VehicleDto> {

        @Override
        public VehicleDto mapRow(ResultSet rs, int index) throws SQLException {

            VehicleDto vehicle = new VehicleDto();
            vehicle.setVin(rs.getString("VIN"));
            vehicle.setYear(rs.getInt("modelYear"));
            vehicle.setExteriorColor(rs.getString("exteriorColor"));
            vehicle.setInteriorColor(rs.getString("interiorColor"));
            vehicle.setBodyType(rs.getString("bodyType"));
            vehicle.setTransmission(rs.getString("transmission"));
            vehicle.setMsrp(rs.getString("msrp"));
            vehicle.setSalePrice(rs.getString("salePrice"));
            vehicle.setPhoto(rs.getString("photo"));
            vehicle.setMileage(rs.getInt("mileage"));
            vehicle.setDescription(rs.getString("description"));
            vehicle.setPurchased(rs.getBoolean("purchased"));
            vehicle.setFeatured(rs.getBoolean("featured"));
            return vehicle;
        }
    }       
}
