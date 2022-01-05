/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.Special;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Cna
 */
public class SpecialDaoImpl implements SpecialDao{
    
    public static final class SpecialMapper implements RowMapper<Special> {

        @Override
        public Special mapRow(ResultSet rs, int index) throws SQLException {
            Special sp = new Special();
            sp.setId(rs.getInt("id"));
            sp.setDescription(rs.getString("description"));
            return sp;
        }
    }     
}
