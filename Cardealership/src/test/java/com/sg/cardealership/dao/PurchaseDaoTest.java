/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.TestApplicationConfiguration;
import com.sg.cardealership.dto.AccountTypeDto;
import com.sg.cardealership.dto.Address;
import com.sg.cardealership.dto.ContactInformationDto;
import com.sg.cardealership.dto.ManufacturerDto;
import com.sg.cardealership.dto.ModelDto;
import com.sg.cardealership.dto.OptionalFeatureDto;
import com.sg.cardealership.dto.Special;
import com.sg.cardealership.dto.UserDto;
import com.sg.cardealership.dto.VehicleDto;
import com.sg.cardealership.dto.purchase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Cna
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class PurchaseDaoTest {
    @Autowired
    AccountTypeDao account;
    @Autowired
    ContactInformationDao contact;
    @Autowired
    ManufacturerDao manufact;
    @Autowired
    ModelDao model;
    @Autowired
    OptionalFeatureDao option;
    @Autowired
    PurchaseDao purchase;
    @Autowired
    SpecialDao special;
    @Autowired
    UserDao use;
    @Autowired
    VehicleDao vehicle;
    
    public PurchaseDaoTest() {
    }
    
    @Before
    public void setUp() {
        List<AccountTypeDto> accounts = account.getAllAccountType();
        for (AccountTypeDto acc : accounts) {
            account.deleteAccountType(acc.getAccountTypeId());
        }
        
        List<ContactInformationDto> contacts = contact.getAllContactInformations();
        for (ContactInformationDto c : contacts) {
            contact.deleteContactById(c.getId());
        }
        
        List<ManufacturerDto> manufacturers = manufact.getAllManufacturers();
        for (ManufacturerDto m : manufacturers) {
            manufact.deleteManufacturerById(m.getId());
        }
        
        List<ModelDto> models = model.getAllModels();
        for (ModelDto m : models) {
            model.deleteModel(m.getId());
        }
        
        List<OptionalFeatureDto> options = option.getAllOptionalFeatures();
        for (OptionalFeatureDto o : options) {
            option.deleteFromOptionalFeature(o.getFeatureId());
        }
        
        List<purchase> purchases = purchase.getAllPurchases();
        for (purchase p : purchases) {
            purchase.deletePurchase(p.getId());
        }
        
        List<Special> specials = special.getAllSpecials();
        for (Special s : specials) {
            special.deleteSpecialById(s.getId());
        }
        
        List<UserDto> users = use.getAllUsers();
        for (UserDto u : users) {
            use.deletUser(u.getUserId());
        }
        
        List<VehicleDto> vehicles = vehicle.getAllVehicle();
        for (VehicleDto v : vehicles) {
            vehicle.deleteVehicleById(v.getVin());
        }
    }

    /**
     * Test of AddgetPurchaseByid method, of class PurchaseDao.
     */
    @Test
    public void testAddGetPurchase() {
        purchase pu = new purchase();
        Address ad = new Address();
        ad.setCity("unknown");
        ad.setState("u1");
        ad.setStreet("num1");
        ad.setZip(12345);
        pu.setAddress(ad);
        
        UserDto user = new UserDto();
        AccountTypeDto acc = new AccountTypeDto();
        acc.setAccountType("admin");
        user.setAccount(acc);
        user.setEmail("c@g.com");
        user.setPassword("12345");
        user.setUserName("s");
        pu.setUser(user);
        
        VehicleDto veh = new VehicleDto();
        ModelDto mod = new ModelDto();
        ManufacturerDto man12 = new ManufacturerDto();
        man12.setCountry("germany");
        man12.setManufacturerName("Unknown");
        mod.setManufacturer(man12);
        mod.setModelName("sa");
        mod.setTrim("trim1");
        veh.setModel(mod);
        OptionalFeatureDto op = new OptionalFeatureDto();
        op.setName("option1");
        List<OptionalFeatureDto> options = new ArrayList<>();
        options.add(op);
        veh.setOptional(options);
        veh.setBodyType("type1");
        veh.setDescription("good car");
        veh.setExteriorColor("yellow");
        veh.setFeatured(true);
        veh.setInteriorColor("black");
        veh.setMileage(1250);
        veh.setMsrp(BigDecimal.ZERO);
        veh.setPhoto("jpg");
        veh.setPurchased(true);
        veh.setSalePrice(BigDecimal.ZERO);
        veh.setTransmission("transmission1");
        veh.setVin("asdasd123123");
        veh.setYear(1234);
        pu.setVehicle(veh);
        
        
        ModelDto fromDao = model.getModelByid(mod1.getId());
        assertEquals(mod1, fromDao);
    }

    /**
     * Test of getAllPurchases method, of class PurchaseDao.
     */
    @Test
    public void testGetAllPurchases() {
    }

    /**
     * Test of getpurchasesForUser method, of class PurchaseDao.
     */
    @Test
    public void testGetpurchasesForUser() {
    }

    /**
     * Test of getpurchasesForVehicle method, of class PurchaseDao.
     */
    @Test
    public void testGetpurchasesForVehicle() {
    }


    /**
     * Test of updatePurchase method, of class PurchaseDao.
     */
    @Test
    public void testUpdatePurchase() {
    }

}
