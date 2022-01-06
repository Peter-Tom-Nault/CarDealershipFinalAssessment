/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.ManufacturerDto;
import java.util.List;

/**
 *
 * @author Cna
 */
public interface ManufacturerDao {
    public List<ManufacturerDto> getAllManufacturers();
    public ManufacturerDto getManufacturerById(int id);
    public ManufacturerDto addManufacturer(ManufacturerDto man);
    public void updateManufacturer(ManufacturerDto man);
    public void deleteManufacturerById(int id);
    
}
