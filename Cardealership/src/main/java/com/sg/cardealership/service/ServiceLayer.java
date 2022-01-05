/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.service;

import com.sg.cardealership.dto.ContactInformationDto;
import com.sg.cardealership.dto.VehicleDto;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Cna
 */
public interface ServiceLayer {

    public List<List<VehicleDto>> ReturnFeatureAndSpecial();

    public List<VehicleDto> getNewBasedOnUserEntry(Map<String, String> map);

    public int insertContacts(ContactInformationDto ContactDto);

    public List<VehicleDto> getSpecials();

    public List<VehicleDto> searchResultForSale(Map<String, String> map);
    
}
