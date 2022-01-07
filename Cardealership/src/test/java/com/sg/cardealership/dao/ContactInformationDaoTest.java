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
public class ContactInformationDaoTest {
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
    
    public ContactInformationDaoTest() {
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
     * Test of AddgetContactInfoById method, of class ContactInformationDao.
     */
    @Test
    public void testAddGetContactInfo() {
        ContactInformationDto contact1 = new ContactInformationDto();
        contact1.setEmail("s@g.com");
        contact1.setFirstName("contactMe");
        contact1.setLastName("contactLast");
        contact1.setMessage("nothingSpecial");
        contact1.setPhone(123456789);
        
        contact1 = contact.addContactInfo(contact1);
        ContactInformationDto fromDao = contact.getContactInfoById(contact1.getId());
        assertEquals(contact1, fromDao);
    }

    /**
     * Test of getAllContactInformations method, of class ContactInformationDao.
     */
    @Test
    public void testGetAllContactInformations() {
        ContactInformationDto contact1 = new ContactInformationDto();
        contact1.setEmail("s@g.com");
        contact1.setFirstName("contactMe");
        contact1.setLastName("contactLast");
        contact1.setMessage("nothingSpecial");
        contact1.setPhone(123456789);
        
        contact1 = contact.addContactInfo(contact1);
        
        ContactInformationDto contact2 = new ContactInformationDto();
        contact2.setEmail("s@g.com2");
        contact2.setFirstName("contactMe2");
        contact2.setLastName("contactLast2");
        contact2.setMessage("nothingSpecial2");
        contact2.setPhone(987654321);
        
        contact2 = contact.addContactInfo(contact2);
        
        List<ContactInformationDto> contacts = contact.getAllContactInformations();
        
        assertEquals(2, contacts.size());
        assertTrue(contacts.contains(contact1));
        assertTrue(contacts.contains(contact2));
    }


    /**
     * Test of updateContact method, of class ContactInformationDao.
     */
    @Test
    public void testUpdateContact() {
        ContactInformationDto contact1 = new ContactInformationDto();
        contact1.setEmail("s@g.com");
        contact1.setFirstName("contactMe");
        contact1.setLastName("contactLast");
        contact1.setMessage("nothingSpecial");
        contact1.setPhone(123456789);
        
        ContactInformationDto fromDao = contact.getContactInfoById(contact1.getId());
        
        assertEquals(contact1, fromDao);
        
        contact1.setEmail("s@g.com2");
        contact1.setFirstName("contactMe2");
        contact1.setLastName("contactLast2");
        contact1.setMessage("nothingSpecial2");
        contact1.setPhone(987654321);
        
        contact.updateContact(contact1);
        
        assertNotEquals(contact1, fromDao);
        
        fromDao = contact.getContactInfoById(contact1.getId());
        
        assertEquals(contact1, fromDao);        
    }

    /**
     * Test of deleteContactById method, of class ContactInformationDao.
     */
    @Test
    public void testDeleteContactById() {
        ContactInformationDto contact1 = new ContactInformationDto();
        contact1.setEmail("s@g.com");
        contact1.setFirstName("contactMe");
        contact1.setLastName("contactLast");
        contact1.setMessage("nothingSpecial");
        contact1.setPhone(123456789);
        
        contact.deleteContactById(contact1.getId());
        
        ContactInformationDto fromDao = contact.getContactInfoById(contact1.getId());
        
        assertNull(fromDao); 
    }    
}
