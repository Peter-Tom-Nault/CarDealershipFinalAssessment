/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.UserDto;
import com.sg.cardealership.dto.VehicleDto;
import com.sg.cardealership.dto.purchase;
import java.util.List;

/**
 *
 * @author Cna
 */
public interface PurchaseDao {
    public purchase getPurchaseByid(int id);
    public List<purchase> getAllPurchases();
    public List<purchase> getpurchasesForUser(UserDto user);
    public List<purchase> getpurchasesForVehicle(VehicleDto vehicle);
    public purchase addPurchase(purchase pu);
    public void updatePurchase(purchase pu);
    public void deletePurchase(int id);
}
