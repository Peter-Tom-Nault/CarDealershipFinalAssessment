/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.service;

import com.sg.cardealership.dto.*;
import java.util.List;
import java.util.Map;
import com.sg.cardealership.dao.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/**
 *
 * @author Cna
 */

@Service
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
    public ServiceLayerImpl()
    {
        
    }

	/**
	 * return a list of vehicles that are featured
	 */
    @Override
    public List<VehicleDto> ReturnFeatureAndSpecial() {
    	vehicles.getFeaturedVehicles();
    }

    /**
     * return list of vehicles that are new (0-1000 miles) and fit given criteria
     */
    @Override
    public List<VehicleDto> getNewBasedOnUserEntry(Map<String, String> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertContacts(ContactInformationDto ContactDto) {
    	contactInfo.addContact(ContactDto);
    }

    @Override
    public List<Special> getSpecials() {
    	return specials.getAllSpecials();
    }

    @Override
    public List<VehicleDto> searchResultForSale(Map<String, String> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public purchase purchase(int vehicleId, com.sg.cardealership.dto.purchase purchase) {
		return purchases.addPurchase(vehicleId, purchase);
	}

	@Override
	public List<VehicleDto> adminSearch(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminAddCar(VehicleDto vehicle) {
		vehicles.addVehicle(vehicle);
	}

	@Override
	public ResponseEntity<VehicleDto> adminUpdateVehicle(VehicleDto vehicle) {
		return vehicles.updateVehicle(vehicle);
	}

	@Override
	public List<UserDto> adminUserListRequest() {
		return users.getAllUsers();
	}

	@Override
	public int adminAddUser(UserDto user) {
		users.addUsers(user);
		return 0;
	}

	@Override
	public int adminUpdateUser(UserDto user) {
		

		if(user.getPassword()user == null) {

		if(user.getPassword() == null) {

			users.updateUser(user, false);
			return 1;
		}		
		else {
			users.updateUser(user, true);
			return 1;
		}
		return 0;
	}

	@Override
	public int accountChangePass(Map<String, String> map) {
		if(map.get("password").equals(map.get("confirmPassword"))) {
			users.updateUser(currentUser, true);
		}
		return 0;
	}

	@Override
	public List<ManufacturerDto> adminMakesList() {
		return manufacturers.getAllMakes();
	}

	@Override
	public int adminAddMake(ManufacturerDto make) {
		manufacturers.addMake(make);
		return 0;
	}

	@Override
	public List<ModelDto> adminModelList() {
		return models.getAllModels();
	}

	@Override
	public int adminAddModel(ModelDto model) {
		models.addModel(model);
		return 0;
	}

	@Override
	public int adminAddSpecial(Special special) {
		specials.addSpecial(special)
		return 0;
	}

	@Override
	public int adminRemoveSpecial(int specialId) {
		specials.removeSpecialById(specialId);
		return 0;
	}

	@Override
	public List<SalesReport> reportSales() {
		return purchases.getSalesRecord();
	}

	@Override
	public List<InventoryReport> reportInventoryNew() {
		return vehicles.getNewInventoryReport();
	}

	@Override
	public List<InventoryReport> reportInventoryUsed() {
		return vehicles.getUsedInventoryReport();
	}

	//Login questions, need to decide how to do logins
	//proposal: have a data structure storing active users and a generated key for them that the browser has access to
	//generate key on login and return and store that value until they log out
	//browser includes that value in any requests that need account based permissions
	@Override
	public int accountLogin(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
