/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.TestApplicationConfiguration;
import com.sg.cardealership.dto.Special;
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
public class SpecialDaoTest {
    
    public SpecialDaoTest() {
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
     * Test of getAllSpecials method, of class SpecialDao.
     */
    @Test
    public void testGetAllSpecials() {
    }

    /**
     * Test of getSpecialById method, of class SpecialDao.
     */
    @Test
    public void testGetSpecialById() {
    }

    /**
     * Test of addSpecialInfo method, of class SpecialDao.
     */
    @Test
    public void testAddSpecialInfo() {
    }

    /**
     * Test of updateSpecial method, of class SpecialDao.
     */
    @Test
    public void testUpdateSpecial() {
    }

    /**
     * Test of deleteSpecialById method, of class SpecialDao.
     */
    @Test
    public void testDeleteSpecialById() {
    }

    public class SpecialDaoImpl implements SpecialDao {

        public List<Special> getAllSpecials() {
            return null;
        }

        public Special getSpecialById(int id) {
            return null;
        }

        public Special addSpecialInfo(Special special) {
            return null;
        }

        public void updateSpecial(Special special) {
        }

        public void deleteSpecialById(int id) {
        }
    }
    
}
