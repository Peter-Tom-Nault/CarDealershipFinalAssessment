/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.TestApplicationConfiguration;
import com.sg.cardealership.dto.ManufacturerDto;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
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
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllManufacturers method, of class ManufacturerDao.
     */
    @Test
    public void testGetAllManufacturers() {
    }

    /**
     * Test of getManufacturerById method, of class ManufacturerDao.
     */
    @Test
    public void testGetManufacturerById() {
    }

    /**
     * Test of addManufacturer method, of class ManufacturerDao.
     */
    @Test
    public void testAddManufacturer() {
    }

    /**
     * Test of updateManufacturer method, of class ManufacturerDao.
     */
    @Test
    public void testUpdateManufacturer() {
    }

    /**
     * Test of deleteManufacturerById method, of class ManufacturerDao.
     */
    @Test
    public void testDeleteManufacturerById() {
    }

    public class ManufacturerDaoImpl implements ManufacturerDao {

        public List<ManufacturerDto> getAllManufacturers() {
            return null;
        }

        public ManufacturerDto getManufacturerById(int id) {
            return null;
        }

        public ManufacturerDto addManufacturer(ManufacturerDto man) {
            return null;
        }

        public void updateManufacturer(ManufacturerDto man) {
        }

        public void deleteManufacturerById(int id) {
        }
    }
    
}
