/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.service;

import com.sg.cardealership.dto.ContactInformationDto;
import com.sg.cardealership.dto.Special;
import com.sg.cardealership.dto.VehicleDto;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Cna
 */
public class ServiceLayerImpl implements ServiceLayer{

    @Override
    public List<VehicleDto> ReturnFeatureAndSpecial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VehicleDto> getNewBasedOnUserEntry(Map<String, String> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertContacts(ContactInformationDto ContactDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Special> getSpecials() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VehicleDto> searchResultForSale(Map<String, String> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
