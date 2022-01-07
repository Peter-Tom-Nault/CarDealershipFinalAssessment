package com.sg.cardealership.controller;

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
import com.sg.cardealership.service.ServiceLayer;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/home")
public class carDealershipController {
    
    ServiceLayer service;
    
    public carDealershipController(ServiceLayer service)
    {
        this.service = service;
    }
    //home/index GET
    //we need to return two jasons, which are feature and special
    //problem is feature will return vehicle and special return model
    //since vehicle have model object inside it we can use this to return
    //special, so first element of list will be feature and second one special
    
    //for now we decided to return just featured vehicle and then in function in js file we use two different calss
    @GetMapping("/index")    
    public List<VehicleDto> homeIndex()
    {
        return service.ReturnFeatureAndSpecial();
    }
    
    //inventory/new GET
    //we should recieve jason as map of different objects, and decide what result we should return
    @GetMapping("/inventory/new/{minYear}/{maxYear}/{minPrice}/{maxPrice}/{yearMakeModel}")
    public List<VehicleDto> inventoryNew(@PathVariable Map<String, String> pathVariables)
    {
    	//@PathVariable("yearMakeModel") String yearMakeModel, @PathVariable("minYear") int minYear, @PathVariable("maxYear") int maxYear, @PathVariable("minPrice") int minPrice, @PathVariable("maxPrice") int maxPrice
    	//System.out.println(map);
    	//HttpHeaders responseHeaders = new HttpHeaders();
    	//System.out.println(yearMakeModel + minYear+maxYear+minPrice+maxPrice);
    	//System.out.println(pathVariables);
        return service.getNewBasedOnUserEntry(pathVariables);
        //return null;
    }
    
    @GetMapping("/inventory/used/{minYear}/{maxYear}/{minPrice}/{maxPrice}/{yearMakeModel}")
    public List<VehicleDto> inventoryUsed(@PathVariable Map<String, String> pathVariables){
    	return service.getUsedBasedOnUserEntry(pathVariables);
    }
    
    //Home/Specials GET
    //list of specials
    //since model manage special we should return models that actually have special((reconsider many to many relationship between model and special))
    @GetMapping("/Specials")
    public List<Special> getSpecials()
    {
        return service.getSpecials();
    }
    
    //Home/Contact POST
    //create a new data in contact info
    //returning just int of created contact
    @PostMapping("/Contact")
    public int insertContacts(@RequestBody ContactInformationDto ContactDto)
    {
        return service.insertContacts(ContactDto);
    }
    
	//need to discuss exactly how logging in works in a RESTful service?
        //will discuss tomorrow
	
    //Sales/Index GET
    //search function that only available to sales person
    @GetMapping("/Sales/Index/{minYear}/{maxYear}/{minPrice}/{maxPrice}/{yearMakeModel}")
    public ResponseEntity<List<VehicleDto>> saleSearch(@PathVariable Map<String, String> pathVariables)
    {
        return ResponseEntity.ok(service.searchResultForSale(pathVariables));
    }
    
    
    //Sales/Purchase/Id POST
    //create new purchase in purchase for the VIN at Id, must be done by sales account
    @PostMapping("/Sales/Purchase/{id}")
    public ResponseEntity<purchase> purchase(@PathVariable int vehicleId, @RequestBody purchase purchase)
    {
    	return ResponseEntity.ok(service.purchase(purchase));
    }
	
    //Admin/Vehicles GET
    //Needs to return json array of vehicles that are available for purchase based on searchc criteria
    @GetMapping("/Admin/Vehicles")
    public List<VehicleDto> adminSearch(@RequestBody Map<String, String> map)
    {
        return service.searchResultForSale(map);
    }
    //Admin/AddVehicle POST
    //add a new vehicle to the database from the information provided
    @PostMapping("/Admin/AddVehicle")
    public int adminAddVehicle(@RequestBody VehicleDto vehicle)
    {
    	
        return service.adminAddCar(vehicle);
    }
	
    //admin/editVehicle/VIN PUT
    //edit the indicated vehicle byt replacing fields with information from json
    @PutMapping("/admin/editVehicle/VIN")
    public void adminUpdateVehicle(@RequestBody VehicleDto vehicle)
    {
        service.adminUpdateVehicle(vehicle);
    }
    
    //admin/users GET
    //return json array of jsons of users
    @GetMapping("/admin/users")
    public List<UserDto> adminUserListRequest()
    {
        return service.adminUserListRequest();
    }
	
    //admin/addUser POST
    //add user to user table with data from input fields
    //since we are getting a user object from the request body we need to confirm that the password is filled and matching on front end
    @PostMapping("/admin/addUser")
    public int AdminaddUser(@RequestBody UserDto user)
    {
        return service.adminAddUser(user);
    }
    
    //admin/editUser PUT
    //update user with information from fields, only change password if fields are not empty and match
    //since we are getting a user object from the request body we need to confirm that the password is filled and matching on front end
    @PutMapping("/admin/editUser")
    public int adminUpdateUser(@RequestBody UserDto user)
    {
        return service.adminUpdateUser(user);
    }
    
    //account/changePassword PUT
    //change the password of the currently logged in user (assuming the fields match)
    @PutMapping("/account/changePassword")
    public int accountChangePass(@RequestBody Map<String, String> map)
    {
        return service.accountChangePass(map);
    }
	
    //admin/makes GET
    //retrieve list of makes and return as json list
    @GetMapping("/admin/makes")
    public List<ManufacturerDto> adminMakesList() {
    	return service.adminMakesList();
    }
    
	//admin/makes POST
	//add manufacturer to manufacturer table  (apparently we need to include date added and who added it, remember to add country field to front end)
	@PostMapping("/admin/makes")
	public int adminAddMake(@RequestBody ManufacturerDto make) {
		return service.adminAddMake(make);
	}
    
	//admin/model GET
	//retrieve list of model jsons (apparently we need to include date added and who added it)
	@GetMapping("/admin/model")
	public ResponseEntity<List<ModelDto>> adminModelList(){
		HttpHeaders responseHeaders = new HttpHeaders();
		return ResponseEntity.ok().headers(responseHeaders).body(service.adminModelList());
	}
	//admin/model POST
	//add new model to model table from fields (apparently we need to include date added and who added it)
	@PostMapping("/admin/model")
	public int adminAddModel(@RequestBody ModelDto model) {
		return service.adminAddModel(model);
	}
	
	//admin/specials GET
	//retrieve list of all specials
	@GetMapping("/admin/specials")
	public List<Special> adminGetSpecialsList(){
		return service.getSpecials();
	}
	
	//admin/specials POST
	//add new special, (remember to add model to front end)
	@PostMapping("/admin/specials")
	public int adminAddSpecial(@RequestBody Special special) {
		return service.adminAddSpecial(special);
	}
	
    //admin/specials DELETE
	//remove selected special from table
	@DeleteMapping("/admin/specials/{id}")
	public int adminDeleteSpecial(@PathVariable int specialId) {
		return service.adminRemoveSpecial(specialId);
	}
	
	//reports/sales GET
	//admin only otherwise return 403, return sales info for filter. Default all users all dates, filter by user and dates available
	//this has a different format from everything else, need to decide how to format the returned object
	@GetMapping("/reports/sales")
	public List<SalesReport> reportSales(@RequestBody Map<String, String> map) {
		return service.reportSales();
	}
	//reports/inventory get
	//return 2 sets. One new one used. Then group by make model. Provide count and sum of MSRP
	@GetMapping("/reports/inventory/new")
	public List<InventoryReport> reportInventoryNew() {
		return service.reportInventoryNew();
	}
	
	@GetMapping("/reports/inventory/used")
	public List<InventoryReport> reportInventoryUsed() {
		return service.reportInventoryUsed();
	}
	
	//account/login POST(?) don't know how log in should work?
	//need to discuss how logging in really works for this and other account specific things
	@PostMapping("/account/login")
	public int accountLogin(@RequestBody Map<String, String> map) {
		return service.accountLogin(map);
	}
	
	@GetMapping("/admin/option")
	public ResponseEntity<List<OptionalFeatureDto>> getOptionalFeatures(){
		HttpHeaders responseHeaders = new HttpHeaders();
		return ResponseEntity.ok().headers(responseHeaders).body(service.getAllOptional());
	}
}
