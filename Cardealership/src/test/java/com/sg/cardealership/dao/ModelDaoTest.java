/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.TestApplicationConfiguration;
import com.sg.cardealership.dto.ManufacturerDto;
import com.sg.cardealership.dto.ModelDto;
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
public class ModelDaoTest {
    
    public ModelDaoTest() {
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
     * Test of getModelByid method, of class ModelDao.
     */
    @Test
    public void testGetModelByid() {
    }

    /**
     * Test of getAllModels method, of class ModelDao.
     */
    @Test
    public void testGetAllModels() {
    }

    /**
     * Test of getModelsForManufacturer method, of class ModelDao.
     */
    @Test
    public void testGetModelsForManufacturer() {
    }

    /**
     * Test of addModel method, of class ModelDao.
     */
    @Test
    public void testAddModel() {
    }

    /**
     * Test of updateModel method, of class ModelDao.
     */
    @Test
    public void testUpdateModel() {
    }

    public class ModelDaoImpl implements ModelDao {

        public ModelDto getModelByid(int id) {
            return null;
        }

        public List<ModelDto> getAllModels() {
            return null;
        }

        public List<ModelDto> getModelsForManufacturer(ManufacturerDto man) {
            return null;
        }

        public ModelDto addModel(ModelDto model) {
            return null;
        }

        public void updateModel(ModelDto model) {
        }
    }
    
}
