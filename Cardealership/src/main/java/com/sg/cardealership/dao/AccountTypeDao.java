/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.AccountTypeDto;
import java.util.List;

/**
 *
 * @author Cna
 */
public interface AccountTypeDao {
    public List<AccountTypeDto> getAllAccountType();
    public AccountTypeDto getAccountTypeById(int id);
    public AccountTypeDto addAccountType(AccountTypeDto AccountType);
    public void updateAccountType(AccountTypeDto account);
    public void deleteAccountType(int id);
}
