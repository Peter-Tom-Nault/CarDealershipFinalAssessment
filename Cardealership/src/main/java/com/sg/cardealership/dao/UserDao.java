/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.AccountTypeDto;
import com.sg.cardealership.dto.UserDto;
import java.util.List;

/**
 *
 * @author Cna
 */
public interface UserDao{
    public UserDto getUserByid(int id);
    public List<UserDto> getAllUsers();
    public List<UserDto> getUsersForAccountType(AccountTypeDto account);
    public UserDto addUser(UserDto user);
    public void updateUser(UserDto user);
    
}
