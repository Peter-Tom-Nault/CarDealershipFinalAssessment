/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import java.util.List;
import java.util.Map;

import com.sg.cardealership.dto.InventoryReport;
import com.sg.cardealership.dto.VehicleDto;

/**
 *
 * @author Cna
 */
public interface VehicleDao {

	List<VehicleDto> getFeaturedVehicles();

	List<VehicleDto> getNewBasedOnUserEntry(Map<String, String> map);

	void addVehicle(VehicleDto vehicle);

	VehicleDto updateVehicle(VehicleDto vehicle);

	List<VehicleDto> getNewVehicles();

	List<VehicleDto> getUsedVehicles();
    
}
