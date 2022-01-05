/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.UserDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import static jdk.vm.ci.sparc.SPARC.sp;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Cna
 */
public class UserDaoImpl implements UserDao{
    
    
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
    
}
