/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dto;

import java.util.List;

/**
 *
 * @author Cna
 */
public class ModelDto {
    private int id;
    private String modelName;
    private String trim;
    
    private ManufacturerDto manufacturer;
	
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getTrim() {
		return trim;
	}
	public void setTrim(String trim) {
		this.trim = trim;
	}
	public ManufacturerDto getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(ManufacturerDto manufacturer) {
		this.manufacturer = manufacturer;
	}
    
    
}
