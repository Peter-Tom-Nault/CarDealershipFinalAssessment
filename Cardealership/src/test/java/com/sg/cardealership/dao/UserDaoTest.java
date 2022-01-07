/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.TestApplicationConfiguration;
import com.sg.cardealership.dto.AccountTypeDto;
import com.sg.cardealership.dto.UserDto;
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
public class UserDaoTest {
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
    
    public UserDaoTest() {
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
     * Test of getUserByid method, of class UserDao.
     */
    @Test
    public void testGetUserByid() {
    }

    /**
     * Test of getAllUsers method, of class UserDao.
     */
    @Test
    public void testGetAllUsers() {
    }

    /**
     * Test of getUsersForAccountType method, of class UserDao.
     */
    @Test
    public void testGetUsersForAccountType() {
    }

    /**
     * Test of addUser method, of class UserDao.
     */
    @Test
    public void testAddUser() {
    }

    /**
     * Test of updateUser method, of class UserDao.
     */
    @Test
    public void testUpdateUser() {
    }

    public class UserDaoImpl implements UserDao {

        public UserDto getUserByid(int id) {
            return null;
        }

        public List<UserDto> getAllUsers() {
            return null;
        }

        public List<UserDto> getUsersForAccountType(AccountTypeDto account) {
            return null;
        }

        public UserDto addUser(UserDto user) {
            return null;
        }

        public void updateUser(UserDto user) {
        }
    }
    
}
