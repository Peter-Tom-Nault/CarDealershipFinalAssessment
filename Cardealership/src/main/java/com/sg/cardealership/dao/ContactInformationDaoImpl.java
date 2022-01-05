/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.AccountTypeDto;
import com.sg.cardealership.dto.ContactInformationDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Cna
 */
public class ContactInformationDaoImpl implements ContactInformationDao{
    @Autowired
    JdbcTemplate jdbc;
    
    public static final class ContactInformationMapper implements RowMapper<ContactInformationDto> {

        @Override
        public ContactInformationDto mapRow(ResultSet rs, int index) throws SQLException {
            ContactInformationDto Contact = new ContactInformationDto();
            Contact.setFirstName(rs.getString("firstName"));
            Contact.setLastName(rs.getString("lastName"));
            Contact.setMessage(rs.getString("message"));
            Contact.setEmail(rs.getString("email"));
            Contact.setPhone(rs.getInt("phone"));
            return Contact;
        }
    }    
}
