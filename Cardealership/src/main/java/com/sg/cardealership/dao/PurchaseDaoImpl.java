/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dao.UserDaoImpl.UserDaoMapper;
import com.sg.cardealership.dao.VehicleDaoImpl.VehicleMapper;
import com.sg.cardealership.dto.Address;
import com.sg.cardealership.dto.OptionalFeatureDto;
import com.sg.cardealership.dto.UserDto;
import com.sg.cardealership.dto.VehicleDto;
import com.sg.cardealership.dto.purchase;
import java.sql.Date;
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
public class PurchaseDaoImpl implements PurchaseDao{
    
    @Autowired
    JdbcTemplate jdbc;    
    
    public static final class PurchaseMapper implements RowMapper<purchase> {

        @Override
        public purchase mapRow(ResultSet rs, int index) throws SQLException {
            purchase pu = new purchase();
            pu.setId(rs.getInt("id"));
            pu.setDate(rs.getDate("date").toLocalDate());
            pu.setPrice(rs.getBigDecimal("purchasePrice"));
            pu.setCustName(rs.getString("customerName"));
            pu.setEmail(rs.getString("email"));
            Address address = new Address();
            address.setCity(rs.getString("city"));
            address.setState(rs.getString("state"));
            address.setStreet(rs.getString("streetAddress"));
            address.setZip(rs.getInt("zip"));
            pu.setAddress(address);
            return pu;
        }
    }
        
    @Override
    public purchase getPurchaseByid(int id) {
        try {
            final String SELECT_PURCHASE_BY_ID = "SELECT * FROM purchase WHERE id = ?";
            purchase pu = jdbc.queryForObject(SELECT_PURCHASE_BY_ID, 
                    new PurchaseMapper(), id);
            pu.setUser(getUserForPurchase(pu));
            pu.setVehicle(getVehicleForPurchase(pu));
            return pu;
        } catch(DataAccessException ex) {
            return null;
        }
    }
    
    private UserDto getUserForPurchase(purchase pu) {
        final String SELECT_USER_FOR_PURCHASE = "SELECT u.* FROM user u "
                + "JOIN purchase pu ON u.userId = pu.salesPersonId WHERE pu.salesPersonId = ?";
        return jdbc.queryForObject(SELECT_USER_FOR_PURCHASE, new UserDaoMapper(), 
                pu.getId());
    }
    
    private VehicleDto getVehicleForPurchase(purchase pu) {
        final String SELECT_VEHICLE_FOR_PURCHASE = "SELECT v.* FROM vehicle v "
                + "JOIN purchase pu ON v.VIN = pu.VIN WHERE pu.VIN = ?";
        return jdbc.queryForObject(SELECT_VEHICLE_FOR_PURCHASE, new VehicleMapper(), 
                pu.getId());
    }
    
    @Override
    public List<purchase> getAllPurchases() {
        final String SELECT_ALL_PURCHASES = "SELECT * FROM purchase";
        List<purchase> purchases = jdbc.query(SELECT_ALL_PURCHASES, new PurchaseMapper());
        
        addUserAndVehicleToPurchases(purchases);
        
        return purchases;
    }
    private void addUserAndVehicleToPurchases(List<purchase> purchases) {
        for(purchase pu : purchases) {
            pu.setUser(getUserForPurchase(pu));
            pu.setVehicle(getVehicleForPurchase(pu));
        }
    }
    
    @Override
    public List<purchase> getpurchasesForUser(UserDto user) {
        final String SELECT_PURCHASES_FOR_USERS = "SELECT * FROM purchase WHERE salesPersonId = ?";
        List<purchase> purchases = jdbc.query(SELECT_PURCHASES_FOR_USERS, 
                new PurchaseMapper(), user.getUserId());
        
        addUserAndVehicleToPurchases(purchases);
        
        return purchases;
    }
    
    @Override
    public List<purchase> getpurchasesForVehicle(VehicleDto vehicle) {
        final String SELECT_PURCHASES_FOR_VEHICLE = "SELECT * FROM purchase WHERE VIN = ?";
        List<purchase> purchases = jdbc.query(SELECT_PURCHASES_FOR_VEHICLE, 
                new PurchaseMapper(), vehicle.getVin());
        
        addUserAndVehicleToPurchases(purchases);
        
        return purchases;
    }
    
    @Override
    @Transactional
    public purchase addPurchase(purchase pu) {
        final String INSERT_PURCHASE = "INSERT INTO purchase(VIN, salesPersonId, date, purchasePrice, customerName, streetAddress, city, state, zip, email) VALUES(?,?,?,?,?,?,?,?,?,?)";
        jdbc.update(INSERT_PURCHASE,
                pu.getVehicle().getVin(),
                pu.getUser().getUserId(),
                Date.valueOf(pu.getDate()),
                pu.getPrice(),
                pu.getCustName(),
                pu.getAddress().getStreet(),
                pu.getAddress().getCity(),
                pu.getAddress().getState(),
                pu.getAddress().getZip(),
                pu.getEmail());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        pu.setId(newId);
        
        return pu;
    }

    @Override
    public void updatePurchase(purchase pu) {
        final String UPDATE_PURCHASE = "UPDATE purchase "
                + "SET VIN = ? salesPersonId = ? date = ? purchasePrice = ? customerName = ? streetAddress = ? city = ? state = ? zip = ? email = ? WHERE id = ?";
        jdbc.update(UPDATE_PURCHASE,
                pu.getVehicle().getVin(),
                pu.getUser().getUserId(),
                Date.valueOf(pu.getDate()),
                pu.getPrice(),
                pu.getCustName(),
                pu.getAddress().getStreet(),
                pu.getAddress().getCity(),
                pu.getAddress().getState(),
                pu.getAddress().getZip(),
                pu.getEmail());
    }

}
    

