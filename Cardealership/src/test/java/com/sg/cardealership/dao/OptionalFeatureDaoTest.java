/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.TestApplicationConfiguration;
import com.sg.cardealership.dto.AccountTypeDto;
import com.sg.cardealership.dto.ContactInformationDto;
import com.sg.cardealership.dto.ManufacturerDto;
import com.sg.cardealership.dto.ModelDto;
import com.sg.cardealership.dto.OptionalFeatureDto;
import com.sg.cardealership.dto.Special;
import com.sg.cardealership.dto.UserDto;
import com.sg.cardealership.dto.VehicleDto;
import com.sg.cardealership.dto.purchase;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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
public class OptionalFeatureDaoTest {
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
    
    public OptionalFeatureDaoTest() {
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
     * Test of getAllOptionalFeatures method, of class OptionalFeatureDao.
     */
    @Test
    public void testGetAllOptionalFeatures() {
        OptionalFeatureDto op1 = new OptionalFeatureDto();
        op1.setName("option1");
        op1 = option.addOptionalFeature(op1);
        
        OptionalFeatureDto op2 = new OptionalFeatureDto();
        op2.setName("option2");
        op2 = option.addOptionalFeature(op2);
        
        List<OptionalFeatureDto> options = option.getAllOptionalFeatures();
        
        assertEquals(2, options.size());
        assertTrue(options.contains(op1));
        assertTrue(options.contains(op2));
    }

    /**
     * Test of AddgetOptionalFeatureById method, of class OptionalFeatureDao.
     */
    @Test
    public void testAddGetOptionalFeatureById() {
        OptionalFeatureDto op1 = new OptionalFeatureDto();
        op1.setName("option1");
        op1 = option.addOptionalFeature(op1);
        OptionalFeatureDto fromDao = option.getOptionalFeatureById(op1.getFeatureId());
        assertEquals(op1, fromDao);
    }


    /**
     * Test of updateOptionalFeature method, of class OptionalFeatureDao.
     */
    @Test
    public void testUpdateOptionalFeature() {
        OptionalFeatureDto op1 = new OptionalFeatureDto();
        op1.setName("option1");
        op1 = option.addOptionalFeature(op1);
        
        OptionalFeatureDto fromDao = option.getOptionalFeatureById(op1.getFeatureId());
        
        assertEquals(op1, fromDao);
        
        op1.setName("option2");
        
        option.updateOptionalFeature(op1);
        
        assertNotEquals(op1, fromDao);
        
        fromDao = option.getOptionalFeatureById(op1.getFeatureId());
        
        assertEquals(op1, fromDao);
    }
    
    @Test
    public void testDeleteOptionalFeatureById() {
        OptionalFeatureDto op1 = new OptionalFeatureDto();
        op1.setName("option1");
        op1 = option.addOptionalFeature(op1);
    
        option.deleteFromOptionalFeature(op1.getFeatureId());
        
        OptionalFeatureDto fromDao = option.getOptionalFeatureById(op1.getFeatureId());
        
        assertNull(fromDao); 
    }

}
