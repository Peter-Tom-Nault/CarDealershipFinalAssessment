/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dto;

/**
 * here user manages accountType
 * @author Cna
 */
public class UserDto {
    private int userId;
    private String userName;
    private String password;
<<<<<<< HEAD
    
    private AccountTypeDto account;
    
=======
    private AccountTypeDto account;
>>>>>>> be16f4f88898b827f3fa5fffca20c43cf2194e7b
    private String email;
    
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AccountTypeDto getAccount() {
		return account;
	}
	public void setAccount(AccountTypeDto account) {
		this.account = account;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}
