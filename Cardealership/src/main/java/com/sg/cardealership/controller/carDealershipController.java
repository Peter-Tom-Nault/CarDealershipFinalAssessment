package com.sg.cardealership.controller;

import com.sg.cardealership.dto.ContactInformationDto;
import com.sg.cardealership.dto.Special;
import com.sg.cardealership.dto.UserDto;
import com.sg.cardealership.dto.VehicleDto;
import com.sg.cardealership.dto.purchase;
import com.sg.cardealership.service.ServiceLayer;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("inventory/new")
    public List<VehicleDto> inventoryNew(@RequestBody Map<String, String> map)
    {
        return service.getNewBasedOnUserEntry(map);
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
    @GetMapping("/Sales/Index")
    public List<VehicleDto> saleSearch(@RequestBody Map<String, String> map)
    {
        return service.searchResultForSale(map);
    }
    
    
    //Sales/Purchase/Id POST
    //create new purchase in purchase for the VIN at Id, must be done by sales account
    @PostMapping("/Sales/Purchase/{id}")
    public void purchase(@PathVariable int vehicleId, @RequestBody purchase purchase)
    {
        service.purchase(vehicleId, purchase);
    }
	
    //Admin/Vehicles GET
    //Needs to return json array of vehicles that are available for purchase based on searchc criteria
    @GetMapping("/Admin/Vehicles")
    public List<VehicleDto> adminSearch(@RequestBody Map<String, String> map)
    {
        return service.adminSearch(map);
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
    public ResponseEntity<VehicleDto> adminUpdateVehicle(@RequestBody VehicleDto vehicle)
    {
        return service.adminUpdateVehicle(vehicle);
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
    @PostMapping("/admin/addUser")
    public int AdminaddUser(@RequestBody UserDto user)
    {
        return service.adminAddUser(user);
    }
    
    //admin/editUser PUT
    //update user with information from fields, only change password if fields are not empty and match
    @PutMapping("/admin/editUser")
    public int adminUpdateUser(@RequestBody UserDto user)
    {
        return service.adminUpdateUser(user);
    }
    
    //account/changePassword PUT
    //change the password of the currently logged in user (assuming the fields match)
    @PutMapping
    public int accountChangePass(@RequestBody Map<String, String> map)
    {
        return service.accountChangePass(map);
    }
	
    //admin/makes GET
    //retrieve list of makes and return as json list
    @GetMapping
    
	//admin/makes POST
	//add manufacturer to manufacturer table  (apparently we need to include date added and who added it, remember to add country field to front end)
	
	//admin/model GET
	//retrieve list of model jsons (apparently we need to include date added and who added it)
	
	//admin/model POST
	//add new model to model table from fields (apparently we need to include date added and who added it)
	
	//admin/specials GET
	//retrieve list of alll specials
	
	//admin/specials POST
	//add new special, (remember to add model to front end)
	
        //admin/specials DELETE
	//remove selected special from table
	
	//reports/index GET
	//list of system reports (? need to define i think its just links to sales and inventory), only admin allowed otherwise return 403 forbidden
	
	//reports/sales GET
	//admin only otherwise return 403, return sales info for filter. Default all users all dates, filter by user and dates available
	
	//reports/inventory get
	//return 2 sets. One new one used. Then group by make model. Provide count and sum of MSRP
	
	//account/login POST(?) don't know how log in should work?
	//need to discuss how logging in really works for this and other account specific things
}
