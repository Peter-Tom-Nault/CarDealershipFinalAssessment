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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cna
 */
public class AccountTypeDaoImpl implements AccountTypeDao{
    @Autowired
    JdbcTemplate jdbc;
    
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
            final String SELECT_ACCOUNTTYPE_BY_ID = "SELECT * FROM accounttypes WHERE id = ?";
            return jdbc.queryForObject(SELECT_ACCOUNTTYPE_BY_ID, new AccountTypeMapper(), id);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public AccountTypeDto addAccountType(AccountTypeDto AccountType) {
        final String INSERT_ACCOUNTTYPE = "INSERT INTO employee(firstName, lastName) "
                + "VALUES(?,?)";
        jdbc.update(INSERT_EMPLOYEE, 
                employee.getFirstName(),
                employee.getLastName());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        employee.setId(newId);
        return employee;
    }

    @Override
    public void updateEmployee(AccountTypeDto employee) {
        final String UPDATE_EMPLOYEE = "UPDATE employee SET firstName = ?, lastName = ? "
                + "WHERE id = ?";
        jdbc.update(UPDATE_EMPLOYEE,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getId());
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        final String DELETE_MEETING_EMPLOYEE = "DELETE FROM meeting_employee "
                + "WHERE employeeId = ?";
        jdbc.update(DELETE_MEETING_EMPLOYEE, id);
        
        final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id = ?";
        jdbc.update(DELETE_EMPLOYEE, id);
    }      
}
}
