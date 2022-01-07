/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.AccountTypeDto;
import com.sg.cardealership.dto.UserDto;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cna
 */
public class UserDaoTest {
    
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
