/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dto;

/**
 *
 * @author Cna
 */
public class ManufacturerDto {
    String manufacturerName;
    String country;
    
    public ManufacturerDto(String name, String country) {
    	this.manufacturerName = name;
    	this.country = country;
    }

	public String getManufacturerName() {
		return manufacturerName;
	}

	public String getCountry() {
		return country;
	}
    
    
}
