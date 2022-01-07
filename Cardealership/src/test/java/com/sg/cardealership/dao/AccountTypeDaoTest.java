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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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
public class AccountTypeDaoTest {
    
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
    
    public AccountTypeDaoTest() {
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
     * Test of AddgetAccountType method, of class AccountTypeDao.
     */
    
    @Test
    public void testAddGetAccountType() {
        AccountTypeDto account1 = new AccountTypeDto();
        account1.setAccountType("admin");
        account1 = account.addAccountType(account1);
        AccountTypeDto fromDao = account.getAccountTypeById(account1.getAccountTypeId());
        assertEquals(account1, fromDao);       
    }
    
    /**
     * Test of getAllAccountType method, of class AccountTypeDao.
     */
    
    @Test
    public void testGetAllAccountType() {
        AccountTypeDto account1 = new AccountTypeDto();
        account1.setAccountType("admin");
        account1 = account.addAccountType(account1);
        
        AccountTypeDto account2 = new AccountTypeDto();
        account2.setAccountType("user");
        account2 = account.addAccountType(account2);
        
        List<AccountTypeDto> accounts = account.getAllAccountType();
        
        assertEquals(2, accounts.size());
        assertTrue(accounts.contains(account1));
        assertTrue(accounts.contains(account2));
    }

    /**
     * Test of updateAccountType method, of class AccountTypeDao.
     */
    
    @Test
    public void testUpdateAccountType() {
        AccountTypeDto account1 = new AccountTypeDto();
        account1.setAccountType("admin");
        account1 = account.addAccountType(account1);
        
        AccountTypeDto fromDao = account.getAccountTypeById(account1.getAccountTypeId());
        
        assertEquals(account1, fromDao);
        
        account1.setAccountType("user");
        
        account.updateAccountType(account1);
        
        assertNotEquals(account1, fromDao);
        
        fromDao = account.getAccountTypeById(account1.getAccountTypeId());
        
        assertEquals(account1, fromDao);
    }
    
    /**
     * Test of DeleteAccountType method, of class AccountTypeDao.
     */
    
    @Test
    public void testDeleteAccountType() {
        AccountTypeDto account1 = new AccountTypeDto();
        account1.setAccountType("admin");
        account1 = account.addAccountType(account1);
        
        account.deleteAccountType(account1.getAccountTypeId());
        
        AccountTypeDto fromDao = account.getAccountTypeById(account1.getAccountTypeId());
        
        assertNull(fromDao);        
    }
    
}
