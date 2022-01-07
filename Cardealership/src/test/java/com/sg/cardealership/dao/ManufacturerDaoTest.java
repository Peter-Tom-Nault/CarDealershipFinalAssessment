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
public class ManufacturerDaoTest {
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
    
    public ManufacturerDaoTest() {
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
     * Test of AddgetManufacturer method, of class ManufacturerDao.
     */
    @Test
    public void testAddGetManufacturer() {
        ManufacturerDto man1 = new ManufacturerDto();
        man1.setCountry("Canada");
        man1.setManufacturerName("BENZ");
        man1 = manufact.addManufacturer(man1);
        ManufacturerDto fromDao = manufact.getManufacturerById(man1.getId());
        assertEquals(man1, fromDao);
    }
    
    /**
     * Test of getAllManufacturers method, of class ManufacturerDao.
     */
    @Test
    public void testGetAllManufacturers() {
        ManufacturerDto man1 = new ManufacturerDto();
        man1.setCountry("Canada");
        man1.setManufacturerName("BENZ");
        man1 = manufact.addManufacturer(man1);
        
        ManufacturerDto man2 = new ManufacturerDto();
        man2.setCountry("Canada1");
        man2.setManufacturerName("BENZ1");
        man2 = manufact.addManufacturer(man2);
        
        List<ManufacturerDto> manfufacts = manufact.getAllManufacturers();
        
        assertEquals(2, manfufacts.size());
        assertTrue(manfufacts.contains(man1));
        assertTrue(manfufacts.contains(man2));
    }

    /**
     * Test of updateManufacturer method, of class ManufacturerDao.
     */
    @Test
    public void testUpdateManufacturer() {
        ManufacturerDto man1 = new ManufacturerDto();
        man1.setCountry("Canada");
        man1.setManufacturerName("BENZ");
        man1 = manufact.addManufacturer(man1);
        
        ManufacturerDto fromDao = manufact.getManufacturerById(man1.getId());
        
        assertEquals(man1, fromDao);
        
        man1.setManufacturerName("BMW");
        
        manufact.updateManufacturer(man1);
        
        assertNotEquals(man1, fromDao);
        
        fromDao = manufact.getManufacturerById(man1.getId());
        
        assertEquals(man1, fromDao);
    }

    /**
     * Test of deleteManufacturerById method, of class ManufacturerDao.
     */
    @Test
    public void testDeleteManufacturerById() {
        ManufacturerDto man1 = new ManufacturerDto();
        man1.setCountry("Canada");
        man1.setManufacturerName("BENZ");
        man1 = manufact.addManufacturer(man1);
        
        manufact.deleteManufacturerById(man1.getId());
        
        ManufacturerDto fromDao = manufact.getManufacturerById(man1.getId());
        
        assertNull(fromDao); 
    }
    
}
