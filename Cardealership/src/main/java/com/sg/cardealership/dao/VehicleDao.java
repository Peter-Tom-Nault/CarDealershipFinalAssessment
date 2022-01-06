/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import java.util.List;
import java.util.Map;

import com.sg.cardealership.dto.InventoryReport;
import com.sg.cardealership.dto.ModelDto;
import com.sg.cardealership.dto.OptionalFeatureDto;
import com.sg.cardealership.dto.VehicleDto;

/**
 *
 * @author Cna
 */
public interface VehicleDao {

    
    public VehicleDto getVehicleByid(int id);
    
    public List<VehicleDto> getAllVehicle();
    
    public List<VehicleDto> getVehiclesForModel(ModelDto model);
    
    public List<VehicleDto> getVehiclesForOption(OptionalFeatureDto option);
    
    public VehicleDto addVehicle(VehicleDto vehicle);
    
    public void updateVehicle(VehicleDto vehicle);
    
    public void deleteVehicleById(int id);
    
    
}
