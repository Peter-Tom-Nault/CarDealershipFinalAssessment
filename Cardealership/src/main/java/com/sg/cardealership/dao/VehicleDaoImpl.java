/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dao.ModelDaoImpl.ModelDaoMapper;
import com.sg.cardealership.dao.OptionalFeatureDaoImpl.OptionalFeatureMapper;
import com.sg.cardealership.dto.ModelDto;
import com.sg.cardealership.dto.OptionalFeatureDto;
import com.sg.cardealership.dto.VehicleDto;
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
public class VehicleDaoImpl implements VehicleDao{
        
    JdbcTemplate jdbc;  
    
    @Autowired
    public VehicleDaoImpl(JdbcTemplate jdbc)
    {
        this.jdbc =jdbc;
    }
    
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
            vehicle.setMsrp(rs.getBigDecimal("msrp"));
            vehicle.setSalePrice(rs.getBigDecimal("salePrice"));
            vehicle.setPhoto(rs.getString("photo"));
            vehicle.setMileage(rs.getInt("mileage"));
            vehicle.setDescription(rs.getString("description"));
            vehicle.setPurchased(rs.getBoolean("purchased"));
            vehicle.setFeatured(rs.getBoolean("featured"));
            return vehicle;
        }
    }  
    
    @Override
    public VehicleDto getVehicleByid(int id) {
        try {
            final String SELECT_VEHICLE_BY_ID = "SELECT * FROM vehicle WHERE vin = ?";
            VehicleDto vehicle = jdbc.queryForObject(SELECT_VEHICLE_BY_ID, 
                    new VehicleMapper(), id);
            vehicle.setModel(getModelForVehicle(vehicle));
            vehicle.setOptional(getOptionsForVehicle(vehicle));
            return vehicle;
        } catch(DataAccessException ex) {
            return null;
        }
    } 
    private ModelDto getModelForVehicle(VehicleDto vehicle) {
        final String SELECT_MODEL_FOR_VEHICLE = "SELECT m.* FROM model m "
                + "JOIN vehicle v ON m.id = v.modelID WHERE v.VIN = ?";
        return jdbc.queryForObject(SELECT_MODEL_FOR_VEHICLE, new ModelDaoMapper(), 
                vehicle.getVin());
    }
    private List<OptionalFeatureDto> getOptionsForVehicle(VehicleDto vehicle) {
        final String SELECT_OPTIONS_FOR_VEHICLE = "SELECT o.* FROM optionalFeature o "
                + "JOIN VehicleOptional vm ON o.featureId = vm.featureId WHERE vm.vehicleVin = ?";
        return jdbc.query(SELECT_OPTIONS_FOR_VEHICLE, new OptionalFeatureMapper(), 
                vehicle.getVin());
    }
    @Override
    public List<VehicleDto> getAllVehicle() {
        final String SELECT_ALL_VEHICLES = "SELECT * FROM vehicle";
        List<VehicleDto> vehicles = jdbc.query(SELECT_ALL_VEHICLES, new VehicleMapper());
        
        addModelAndOptionsToVehicles(vehicles);
        
        return vehicles;
    }
    private void addModelAndOptionsToVehicles(List<VehicleDto> vehicles) {
        for(VehicleDto vehicle : vehicles) {
            vehicle.setModel(getModelForVehicle(vehicle));
            vehicle.setOptional(getOptionsForVehicle(vehicle));
        }
    }
    @Override
    public List<VehicleDto> getVehiclesForModel(ModelDto model) {
        final String SELECT_VEHICLES_FOR_MODEL = "SELECT * FROM vehicle WHERE modelID = ?";
        List<VehicleDto> vehicles = jdbc.query(SELECT_VEHICLES_FOR_MODEL, 
                new VehicleMapper(), model.getId());
        
        addModelAndOptionsToVehicles(vehicles);
        
        return vehicles;
    }
    @Override
    public List<VehicleDto> getVehiclesForOption(OptionalFeatureDto option) {
        final String SELECT_VEHICLES_FOR_OPTION = "SELECT * FROM vehicle v "
                + "JOIN vehicleoptional vo ON v.vin = vo.vehiclevin WHERE vo.featureId = ?";
        List<VehicleDto> vehicles = jdbc.query(SELECT_VEHICLES_FOR_OPTION, 
                new VehicleMapper(), option.getFeatureId());
        
        addModelAndOptionsToVehicles(vehicles);
        
        return vehicles;
    }
    @Override
    @Transactional
    public VehicleDto addVehicle(VehicleDto vehicle) {
        final String INSERT_VEHICLE = "INSERT INTO vehicle(VIN, modelID, modelYear, exteriorColor, interiorColor, bodyType, transmission, msrp, saleprice, photo, mileage, description, purchased, featured) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbc.update(INSERT_VEHICLE,
                vehicle.getVin(),
                vehicle.getModel().getId(),
                vehicle.getYear(),
                vehicle.getExteriorColor(),
                vehicle.getInteriorColor(),
                vehicle.getBodyType(),
                vehicle.getTransmission(),
                vehicle.getMsrp(),
                vehicle.getSalePrice(),
                vehicle.getPhoto(),
                vehicle.getMileage(),
                vehicle.getDescription(),
                vehicle.isPurchased(),
                vehicle.isFeatured());
        
        insertVehicleOptional(vehicle);
        
        return vehicle;
    }
    private void insertVehicleOptional(VehicleDto vehicle) {
        final String INSERT_VEHICLE_OPTIONAL = "INSERT INTO vehicleOptional"
                + "(vehicleVin, featureId) VALUES(?,?)";
        for(OptionalFeatureDto option : vehicle.getOptional()) {
            jdbc.update(INSERT_VEHICLE_OPTIONAL, vehicle.getVin(), option.getFeatureId());
        }
    }
    @Override
    @Transactional
    public void updateVehicle(VehicleDto vehicle) {
        final String UPDATE_VEHICLE = "UPDATE vehicle "
                + "SET modelID = ?, modelYear = ?, exteriorColor = ?, interiorColor = ?, bodyType = ?, transmission = ?, msrp = ?, saleprice = ?, photo = ?, mileage = ?, description = ?, purchased = ?, featured = ? "+
        		"WHERE vin = ?";
        jdbc.update(UPDATE_VEHICLE,
                vehicle.getModel().getId(),
                vehicle.getYear(),
                vehicle.getExteriorColor(),
                vehicle.getInteriorColor(),
                vehicle.getBodyType(),
                vehicle.getTransmission(),
                vehicle.getMsrp(),
                vehicle.getSalePrice(),
                vehicle.getPhoto(),
                vehicle.getMileage(),
                vehicle.getDescription(),
                vehicle.isPurchased(),
                vehicle.isFeatured(),
                vehicle.getVin());
        
        final String DELETE_VEHICLE_OPTIONAL = "DELETE FROM vehicleOptional "
                + "WHERE vehicleVin = ?";
        jdbc.update(DELETE_VEHICLE_OPTIONAL, vehicle.getVin());
        insertVehicleOptional(vehicle);
    }
    @Override
    @Transactional
    public void deleteVehicleById(String id) {
        final String DELETE_VEHICLE_OPTIONAL = "DELETE FROM vehicleoptional "
                + "WHERE vehicleVin = ?";
        jdbc.update(DELETE_VEHICLE_OPTIONAL, id);
    
        final String DELETE_VEHICLE_PURCHASE = "DELETE FROM purchase "
                + "WHERE VIN = ?";
        jdbc.update(DELETE_VEHICLE_PURCHASE, id);
            
        final String DELETE_VEHICLE = "DELETE FROM vehicle WHERE VIN = ?";
        jdbc.update(DELETE_VEHICLE, id);
    }    
}
