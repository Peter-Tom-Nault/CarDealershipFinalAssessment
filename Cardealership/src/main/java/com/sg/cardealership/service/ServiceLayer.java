/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.service;

import com.sg.cardealership.dto.ContactInformationDto;
import com.sg.cardealership.dto.InventoryReport;
import com.sg.cardealership.dto.ManufacturerDto;
import com.sg.cardealership.dto.ModelDto;
import com.sg.cardealership.dto.OptionalFeatureDto;
import com.sg.cardealership.dto.SalesReport;
import com.sg.cardealership.dto.Special;
import com.sg.cardealership.dto.UserDto;
import com.sg.cardealership.dto.VehicleDto;
import com.sg.cardealership.dto.purchase;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

/**
 *
 * @author Cna
 */
public interface ServiceLayer {

    public List<VehicleDto> ReturnFeatureAndSpecial();

    public List<VehicleDto> getNewBasedOnUserEntry(Map<String, String> map);

    public int insertContacts(ContactInformationDto ContactDto);

    public List<Special> getSpecials();

    public List<VehicleDto> searchResultForSale(Map<String, String> map);

	public purchase purchase(purchase purchase);

	public List<VehicleDto> adminSearch(Map<String, String> map);

	public int adminAddCar(VehicleDto vehicle);

	public void adminUpdateVehicle(VehicleDto vehicle);

	public List<UserDto> adminUserListRequest();

	public int adminAddUser(UserDto user);

	public int adminUpdateUser(UserDto user);

	public int accountChangePass(Map<String, String> map);

	public List<ManufacturerDto> adminMakesList();

	public int adminAddMake(ManufacturerDto make);

	public List<ModelDto> adminModelList();

	public int adminAddModel(ModelDto model);

	public int adminAddSpecial(Special special);

	public int adminRemoveSpecial(int specialId);

	public List<SalesReport> reportSales();

	public List<InventoryReport> reportInventoryNew();

	public List<InventoryReport> reportInventoryUsed();

	public int accountLogin(Map<String, String> map);

	public List<VehicleDto> getUsedBasedOnUserEntry(Map<String, String> map);

	public List<OptionalFeatureDto> getAllOptional();

    
}
