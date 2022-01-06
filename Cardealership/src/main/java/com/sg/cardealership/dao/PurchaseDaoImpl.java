/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.OptionalFeatureDto;
import com.sg.cardealership.dto.purchase;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Cna
 */
public class PurchaseDaoImpl implements PurchaseDao{
    
    public static final class PurchaseMapper implements RowMapper<purchase> {

        @Override
        public purchase mapRow(ResultSet rs, int index) throws SQLException {
            purchase pu = new purchase();
            pu.setId(rs.getInt("id"));
            pu.setDate(rs.getDate("date").toLocalDate());
            pu.setPrice(rs.getBigDecimal("purchasePrice"));
            pu.setCustName(rs.getString("customerName"));
            pu.setEmail(rs.getString("email"));
            return pu;
        }
    } 
    
}
