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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
public class ModelDaoTest {
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
    
    public ModelDaoTest() {
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
     * Test of AddgetModel method, of class ModelDao.
     */
    @Test
    public void testAddGetModel() {
        ModelDto mod1 = new ModelDto();
        ManufacturerDto man = new ManufacturerDto();
        man.setCountry("Canada");
        man.setManufacturerName("BMW");
        man = manufact.addManufacturer(man);
        mod1.setManufacturer(man);
        mod1.setModelName("1500");
        mod1.setTrim("trim1");
        mod1 = model.addModel(mod1);
        
        ModelDto fromDao = model.getModelByid(mod1.getId());
        assertEquals(mod1, fromDao);
    }

    /**
     * Test of getAllModels method, of class ModelDao.
     */
    @Test
    public void testGetAllModels() {
        ModelDto mod1 = new ModelDto();
        ManufacturerDto man = new ManufacturerDto();
        man.setCountry("Canada");
        man.setManufacturerName("BMW");
        man = manufact.addManufacturer(man);
        mod1.setManufacturer(man);
        mod1.setModelName("1500");
        mod1.setTrim("trim1");
        mod1 = model.addModel(mod1);
        
        ModelDto mod2 = new ModelDto();
        ManufacturerDto man1 = new ManufacturerDto();
        man1.setCountry("Canada1");
        man1.setManufacturerName("BMW1");
        man1 = manufact.addManufacturer(man1);
        mod2.setManufacturer(man1);
        mod2.setModelName("15001");
        mod2.setTrim("trim11");
        mod2 = model.addModel(mod2);
        
        List<ModelDto> models = model.getAllModels();
        
        assertEquals(2, models.size());
        assertTrue(models.contains(mod1));
        assertTrue(models.contains(mod2));
    }

    /**
     * Test of getModelsForManufacturer method, of class ModelDao.
     */
    @Test
    public void testGetModelsForManufacturer() {
        ManufacturerDto man = new ManufacturerDto();
        man.setCountry("Canada");
        man.setManufacturerName("BMW");
        man = manufact.addManufacturer(man);
        
        ModelDto mod1 = new ModelDto();
        mod1.setManufacturer(man);
        mod1.setModelName("1500");
        mod1.setTrim("trim1");
        mod1 = model.addModel(mod1);
        
        ModelDto mod2 = new ModelDto();
        mod2.setManufacturer(man);
        mod2.setModelName("15001");
        mod2.setTrim("trim11");
        mod2 = model.addModel(mod2);
        
        List<ModelDto> modelsforManufacture = model.getModelsForManufacturer(man);
        
        assertEquals(2, modelsforManufacture.size());
        assertTrue(modelsforManufacture.contains(mod1));
        assertTrue(modelsforManufacture.contains(mod2));
    }

    /**
     * Test of updateModel method, of class ModelDao.
     */
    @Test
    public void testUpdateModel() {
        ManufacturerDto man1 = new ManufacturerDto();
        man1.setCountry("Canada");
        man1.setManufacturerName("BENZ");
        man1 = manufact.addManufacturer(man1);
        
        ModelDto mod1 = new ModelDto();
        mod1.setManufacturer(man1);
        mod1.setModelName("1500");
        mod1.setTrim("trim1");
        mod1 = model.addModel(mod1);
        
        ModelDto fromDao = model.getModelByid(mod1.getId());
        
        assertEquals(mod1, fromDao);
        
        mod1.setModelName("15001");
        
        model.updateModel(mod1);
        
        assertNotEquals(mod1, fromDao);
        
        fromDao = model.getModelByid(mod1.getId());
        
        assertEquals(mod1, fromDao);
        
    }
    
    @Test
    public void testDeleteModelById() {
        ManufacturerDto man1 = new ManufacturerDto();
        man1.setCountry("Canada");
        man1.setManufacturerName("BENZ");
        man1 = manufact.addManufacturer(man1);
        
        ModelDto mod1 = new ModelDto();
        mod1.setManufacturer(man1);
        mod1.setModelName("1500");
        mod1.setTrim("trim1");
        mod1 = model.addModel(mod1);
        
        model.deleteModel(mod1.getId());
        
        ModelDto fromDao = model.getModelByid(mod1.getId());
        
        assertNull(fromDao); 
    }

}
