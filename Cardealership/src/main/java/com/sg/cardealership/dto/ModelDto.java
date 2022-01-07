/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dto;

import java.util.List;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.modelName);
        hash = 23 * hash + Objects.hashCode(this.trim);
        hash = 23 * hash + Objects.hashCode(this.manufacturer);
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
        final ModelDto other = (ModelDto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.modelName, other.modelName)) {
            return false;
        }
        if (!Objects.equals(this.trim, other.trim)) {
            return false;
        }
        if (!Objects.equals(this.manufacturer, other.manufacturer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelDto{" + "id=" + id + ", modelName=" + modelName + ", trim=" + trim + ", manufacturer=" + manufacturer + '}';
    }
    
    
}
