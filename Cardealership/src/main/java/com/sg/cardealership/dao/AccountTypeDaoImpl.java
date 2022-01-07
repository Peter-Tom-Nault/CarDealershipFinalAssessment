/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.AccountTypeDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cna
 */
@Repository
public class AccountTypeDaoImpl implements AccountTypeDao{
    
    JdbcTemplate jdbc;
    
    @Autowired
    public AccountTypeDaoImpl(JdbcTemplate jdbc)
    {
        this.jdbc = jdbc;
    }
    
    public static final class AccountTypeMapper implements RowMapper<AccountTypeDto> {

        @Override
        public AccountTypeDto mapRow(ResultSet rs, int index) throws SQLException {
            AccountTypeDto accType = new AccountTypeDto();
            accType.setAccountTypeId(rs.getInt("accountTypeId"));
            accType.setAccountType(rs.getString("accountType"));
            return accType;
        }
    }
    
    @Override
    public List<AccountTypeDto> getAllAccountType() {
        final String SELECT_ALL_ACCOUNTTYPES = "SELECT * FROM accounttypes";
        return jdbc.query(SELECT_ALL_ACCOUNTTYPES, new AccountTypeMapper());
    }

    @Override
    public AccountTypeDto getAccountTypeById(int id) {
        try {
            final String SELECT_ACCOUNTTYPE_BY_ID = "SELECT * FROM accounttypes WHERE accountTypeId = ?";
            return jdbc.queryForObject(SELECT_ACCOUNTTYPE_BY_ID, new AccountTypeMapper(), id);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public AccountTypeDto addAccountType(AccountTypeDto AccountType) {
        final String INSERT_ACCOUNTTYPE = "INSERT INTO Accounttypes(accountType) "
                + "VALUES(?)";
        jdbc.update(INSERT_ACCOUNTTYPE,
                AccountType.getAccountType());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        AccountType.setAccountTypeId(newId);
        return AccountType;
    }

    @Override
    public void updateAccountType(AccountTypeDto account) {
        final String UPDATE_ACCOUNTTYPE = "UPDATE accounttypes SET accountType = ? "
                + "WHERE accountTypeId = ?";
        jdbc.update(UPDATE_ACCOUNTTYPE,
                account.getAccountType(),
                account.getAccountTypeId());
    }
    
    @Override
    public void deleteAccountType(int id)
    {
        final String DELETE_ACCOUNTTYPE_USER = "DELETE FROM user WHERE accounttype = ?";
        jdbc.update(DELETE_ACCOUNTTYPE_USER, id); 
        
        final String DELETE_ACCOUNTTYPE = "DELETE FROM accounttypes WHERE accounttypeid = ?";
        jdbc.update(DELETE_ACCOUNTTYPE, id);        
    }

}
