/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.service;

import com.sg.cardealership.dto.ContactInformationDto;
import com.sg.cardealership.dto.ManufacturerDto;
import com.sg.cardealership.dto.ModelDto;
import com.sg.cardealership.dto.Special;
import com.sg.cardealership.dto.UserDto;
import com.sg.cardealership.dto.VehicleDto;
import java.util.List;
import java.util.Map;
import com.sg.cardealership.dao.*;

import org.springframework.http.ResponseEntity;

/**
 *
 * @author Cna
 */
public class ServiceLayerImpl implements ServiceLayer{
	
	AccountTypeDao accountType;
	ContactInformationDao contactInfo;
	ManufacturerDao manufacturers;
	ModelDao models;
	OptionalFeatureDao optFeatures;
	PurchaseDao purchases;
	SpecialDao specials;
	UserDao users;
	VehicleDao vehicles;

    @Override
    public List<VehicleDto> ReturnFeatureAndSpecial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VehicleDto> getNewBasedOnUserEntry(Map<String, String> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertContacts(ContactInformationDto ContactDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Special> getSpecials() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VehicleDto> searchResultForSale(Map<String, String> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public void purchase(int vehicleId, com.sg.cardealership.dto.purchase purchase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VehicleDto> adminSearch(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminAddCar(VehicleDto vehicle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResponseEntity<VehicleDto> adminUpdateVehicle(VehicleDto vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> adminUserListRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminAddUser(UserDto user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminUpdateUser(UserDto user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int accountChangePass(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ManufacturerDto> adminMakesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminAddMake(ManufacturerDto make) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ModelDto> adminModelList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminAddModel(ModelDto model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminAddSpecial(Special special) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminRemoveSpecial() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reportSales() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reportInventoryNew() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reportInventoryUsed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int accountLogin(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
