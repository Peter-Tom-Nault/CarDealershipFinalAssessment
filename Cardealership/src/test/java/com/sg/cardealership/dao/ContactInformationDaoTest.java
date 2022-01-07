/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.TestApplicationConfiguration;
import com.sg.cardealership.dto.ContactInformationDto;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Cna
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class ContactInformationDaoTest {
    
    public ContactInformationDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllContactInformations method, of class ContactInformationDao.
     */
    @Test
    public void testGetAllContactInformations() {
    }

    /**
     * Test of getContactInfoById method, of class ContactInformationDao.
     */
    @Test
    public void testGetContactInfoById() {
    }

    /**
     * Test of addContactInfo method, of class ContactInformationDao.
     */
    @Test
    public void testAddContactInfo() {
    }

    /**
     * Test of updateContact method, of class ContactInformationDao.
     */
    @Test
    public void testUpdateContact() {
    }

    /**
     * Test of deleteContactById method, of class ContactInformationDao.
     */
    @Test
    public void testDeleteContactById() {
    }

    public class ContactInformationDaoImpl implements ContactInformationDao {

        public List<ContactInformationDto> getAllContactInformations() {
            return null;
        }

        public ContactInformationDto getContactInfoById(int id) {
            return null;
        }

        public ContactInformationDto addContactInfo(ContactInformationDto contact) {
            return null;
        }

        public void updateContact(ContactInformationDto contact) {
        }

        public void deleteContactById(int id) {
        }
    }
    
}
