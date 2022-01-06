/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.service;

import com.sg.cardealership.dto.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sg.cardealership.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

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
        
    @Autowired
    public ServiceLayerImpl(AccountTypeDao accountType, ContactInformationDao contactInfo, ManufacturerDao manufacturers,
    ModelDao models, OptionalFeatureDao optFeatures, PurchaseDao purchases, SpecialDao specials, UserDao users, VehicleDao vehicles)
    {
        this.accountType = accountType;
        this.contactInfo = contactInfo;
        this.manufacturers = manufacturers;
        this.models = models;
        this.optFeatures = optFeatures;
        this.purchases = purchases;
        this.specials = specials;
        this.users = users;
        this.vehicles = vehicles;
    }

	/**
	 * return a list of vehicles that are featured
	 */
    @Override
    public List<VehicleDto> ReturnFeatureAndSpecial() {
    	List<VehicleDto> allvehicles = vehicles.getAllVehicle();
    	List<VehicleDto> featuredVehicles = allvehicles.stream().filter((v) -> v.isFeatured()).collect(Collectors.toList());
    	return featuredVehicles;
    }

    /**
     * return list of vehicles that are new (0-1000 miles) and fit given criteria
     */
    @Override
    public List<VehicleDto> getNewBasedOnUserEntry(Map<String, String> map) {
    	List<VehicleDto> filtered = searchVehiclesByConditions(map);
    	return filtered.stream().filter((v) -> v.getMileage()<=1000).collect(Collectors.toList());
    }
    
    @Override
	public List<VehicleDto> getUsedBasedOnUserEntry(Map<String, String> map) {
    	List<VehicleDto> filtered = searchVehiclesByConditions(map);
    	return filtered.stream().filter((v) -> v.getMileage()>1000).collect(Collectors.toList());
	}

    @Override
    public int insertContacts(ContactInformationDto ContactDto) {
    	ContactInformationDto addedContact = contactInfo.addContactInfo(ContactDto);
    	if(addedContact.getId() != ContactDto.getId()) {
    		return 1;
    	}
    	return 0;
    }

    @Override
    public List<Special> getSpecials() {
    	return specials.getAllSpecials();
    }

    @Override
    public List<VehicleDto> searchResultForSale(Map<String, String> map) {
        List<VehicleDto> allVehicles = vehicles.getAllVehicle();
        List<String> allPurchasedVehicles = purchases.getAllPurchases().stream().map((p) -> p.getVehicle().getVin()).collect(Collectors.toList());
        return allVehicles.stream().filter((v) -> !allPurchasedVehicles.contains(v.getVin())).collect(Collectors.toList());
    }

	@Override
	public purchase purchase(com.sg.cardealership.dto.purchase purchase) {
		return purchases.addPurchase(purchase);
	}

	
	//I think this is not needed, search behaves identically to sales search
	@Override
	public List<VehicleDto> adminSearch(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int adminAddCar(VehicleDto vehicle) {
		vehicles.addVehicle(vehicle);
		return 0;
	}

	@Override
	public void adminUpdateVehicle(VehicleDto vehicle) {
		vehicles.updateVehicle(vehicle);
	}

	@Override
	public List<UserDto> adminUserListRequest() {
		return users.getAllUsers();
	}

	@Override
	public int adminAddUser(UserDto user) {
		users.addUser(user);
		return 0;
	}

	@Override
	public int adminUpdateUser(UserDto user) {
		
		if(user.getPassword() == null) {
			user.setPassword(users.getUserByid(user.getUserId()).getPassword());
		}
		
		users.updateUser(user);
		
		return 0;
	}

	//this needs login stuff so it can only affect the current user
	@Override
	public int accountChangePass(Map<String, String> map) {
		/*
		if(map.get("password").equals(map.get("confirmPassword"))) {
			users.updateUser(currentUser, true);
		}
		
		*/
		return 0;
	}

	@Override
	public List<ManufacturerDto> adminMakesList() {
		return manufacturers.getAllManufacturers();
	}

	@Override
	public int adminAddMake(ManufacturerDto make) {
		manufacturers.addManufacturer(make);
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
		specials.addSpecialInfo(special);
		return 0;
	}

	@Override
	public int adminRemoveSpecial(int specialId) {
		specials.deleteSpecialById(specialId);
		return 0;
	}

	@Override
	public List<SalesReport> reportSales() {
		List<purchase> salesHistory = purchases.getAllPurchases();
		Map<UserDto, List<purchase>> purchasesByUser = salesHistory.stream().collect(Collectors.groupingBy(purchase::getUser));
		List<SalesReport> sales = new ArrayList<>();
		for(List<purchase> userPurchases: purchasesByUser.values()) {
			
				sales.add(new SalesReport(userPurchases));
			
		}
		return sales;
	}

	@Override
	public List<InventoryReport> reportInventoryNew() {
		List<VehicleDto> newVehicles = vehicles.getAllVehicle().stream().filter((v) -> v.getMileage()<1000).collect(Collectors.toList());
		Map<ModelDto, List<VehicleDto>> vehiclesByModel = newVehicles.stream().collect(Collectors.groupingBy(VehicleDto::getModel));
		List<InventoryReport> invReport = new ArrayList<>();
		for(List<VehicleDto> vehicleList: vehiclesByModel.values()) {
			invReport.add(new InventoryReport(vehicleList));
		}
		return invReport;
	}

	@Override
	public List<InventoryReport> reportInventoryUsed() {
		List<VehicleDto> usedVehicles =  vehicles.getAllVehicle().stream().filter((v) -> v.getMileage()>=1000).collect(Collectors.toList());
		Map<ModelDto, List<VehicleDto>> vehiclesByModel = usedVehicles.stream().collect(Collectors.groupingBy(VehicleDto::getModel));
		List<InventoryReport> invReport = new ArrayList<>();
		for(List<VehicleDto> vehicleList: vehiclesByModel.values()) {
			invReport.add(new InventoryReport(vehicleList));
		}
		return invReport;
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
	
	private List<VehicleDto> searchVehiclesByConditions(Map<String, String> cond){
		List<VehicleDto> all = vehicles.getAllVehicle();
		String yearMakeModel =  cond.get("yearMakeModel");
		all = all.stream().filter((v) -> (v.getYear() + " " + v.getModel().getModelName() + " " + v.getModel().getManufacturer().getManufacturerName()).contains(yearMakeModel)).collect(Collectors.toList());
		all = all.stream().filter((v) -> v.getYear() > Integer.parseInt(cond.get("minYear")) && v.getYear() < Integer.parseInt(cond.get("maxYear"))).collect(Collectors.toList());
		all = all.stream().filter((v) -> (v.getMsrp().compareTo(new BigDecimal(cond.get("minPrice"))) >= 0) && v.getMsrp().compareTo(new BigDecimal(cond.get("maxPrice"))) <=0 ).collect(Collectors.toList());
		return all;
	}

	
    
}
