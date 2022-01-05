/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.AccountTypeDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
    
}
