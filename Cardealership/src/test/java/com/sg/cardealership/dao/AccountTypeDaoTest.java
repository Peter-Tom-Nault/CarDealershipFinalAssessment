/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.TestApplicationConfiguration;
import com.sg.cardealership.dto.AccountTypeDto;
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

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllAccountType method, of class AccountTypeDao.
     */
    @Test
    public void testGetAllAccountType() {
    }

    /**
     * Test of getAccountTypeById method, of class AccountTypeDao.
     */
    @Test
    public void testGetAccountTypeById() {
    }

    /**
     * Test of addAccountType method, of class AccountTypeDao.
     */
    @Test
    public void testAddAccountType() {
    }

    /**
     * Test of updateAccountType method, of class AccountTypeDao.
     */
    @Test
    public void testUpdateAccountType() {
    }

    public class AccountTypeDaoImpl implements AccountTypeDao {

        public List<AccountTypeDto> getAllAccountType() {
            return null;
        }

        public AccountTypeDto getAccountTypeById(int id) {
            return null;
        }

        public AccountTypeDto addAccountType(AccountTypeDto AccountType) {
            return null;
        }

        public void updateAccountType(AccountTypeDto account) {
        }
    }
    
}
