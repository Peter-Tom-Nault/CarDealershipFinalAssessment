/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dao.AccountTypeDaoImpl.AccountTypeMapper;
import com.sg.cardealership.dto.AccountTypeDto;
import com.sg.cardealership.dto.UserDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cna
 */
public class UserDaoImpl implements UserDao{

    @Autowired
    JdbcTemplate jdbc;     
    
    public static final class UserDaoMapper implements RowMapper<UserDto> {

        @Override
        public UserDto mapRow(ResultSet rs, int index) throws SQLException {
            UserDto user = new UserDto();
            user.setUserId(rs.getInt("userId"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    }       
    @Override
    public UserDto getUserByid(int id) {
        try {
            final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE userId = ?";
            UserDto user = jdbc.queryForObject(SELECT_USER_BY_ID, 
                    new UserDaoMapper(), id);
            user.setAccount(getAccountTypeForUser(user));
            return user;
        } catch(DataAccessException ex) {
            return null;
        }
    }
    
    private AccountTypeDto getAccountTypeForUser(UserDto user) {
        final String SELECT_ACCOUNT_FOR_USER = "SELECT a.* FROM accountTypes a "
                + "JOIN user u ON u.accountType = a.accountTypeId WHERE u.userId = ?";
        return jdbc.queryForObject(SELECT_ACCOUNT_FOR_USER, new AccountTypeMapper(), 
                user.getUserId());
    }
    
    @Override
    public List<UserDto> getAllUsers() {
        final String SELECT_ALL_USERS = "SELECT * FROM user";
        List<UserDto> users = jdbc.query(SELECT_ALL_USERS, new UserDaoMapper());
        
        addAccountTypeToUsers(users);
        
        return users;
    }
    
    private void addAccountTypeToUsers(List<UserDto> users) {
        for(UserDto user : users) {
            user.setAccount(getAccountTypeForUser(user));
        }
    }
    
    @Override
    public List<UserDto> getUsersForAccountType(AccountTypeDto account) {
        final String SELECT_USERS_FOR_ACCOUNTTYPE = "SELECT * FROM user WHERE accountType = ?";
        List<UserDto> users = jdbc.query(SELECT_USERS_FOR_ACCOUNTTYPE, 
                new UserDaoMapper(), account.getAccountTypeId());
        
        addAccountTypeToUsers(users);
        
        return users;
    }
    
    @Override
    @Transactional
    public UserDto addUser(UserDto user) {
        final String INSERT_USER = "INSERT INTO user(username, accountType, passowrd, email) VALUES(?,?,?,?)";
        jdbc.update(INSERT_USER,
                user.getUserName(),
                user.getAccount().getAccountTypeId(),
                user.getPassword(),
                user.getEmail());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        user.setUserId(newId);
        
        return user;
    }

    @Override
    public void updateUser(UserDto user) {
        final String UPDATE_USER = "UPDATE user "
                + "SET username = ? accountType = ? passowrd = ? email = ? WHERE id = ?";
        jdbc.update(UPDATE_USER,
                user.getUserName(),
                user.getAccount().getAccountTypeId(),
                user.getPassword(),
                user.getEmail(),
                user.getUserId());
    }
    
}
