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
    private int id;
    private String manufacturerName;
    private String country;
    
    public ManufacturerDto(int id, String name, String country) {
    	this.id = id;
    	this.manufacturerName = name;
    	this.country = country;
    }
    
    

	public String getManufacturerName() {
		return manufacturerName;
	}

	public String getCountry() {
		return country;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}



	public void setCountry(String country) {
		this.country = country;
	}
    
    
}
