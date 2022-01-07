/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dto;

import java.util.Objects;

/**
 *
 * @author Cna
 */
public class ManufacturerDto {
    private int id;
    private String manufacturerName;
    private String country;
    
        
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.manufacturerName);
        hash = 53 * hash + Objects.hashCode(this.country);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ManufacturerDto other = (ManufacturerDto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.manufacturerName, other.manufacturerName)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ManufacturerDto{" + "id=" + id + ", manufacturerName=" + manufacturerName + ", country=" + country + '}';
    }
    
    
}
