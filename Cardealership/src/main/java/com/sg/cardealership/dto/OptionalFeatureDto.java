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
public class OptionalFeatureDto {
    private int featureId;
    private String name;
    
	public int getFeatureId() {
		return featureId;
	}
	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.featureId;
        hash = 23 * hash + Objects.hashCode(this.name);
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
        final OptionalFeatureDto other = (OptionalFeatureDto) obj;
        if (this.featureId != other.featureId) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OptionalFeatureDto{" + "featureId=" + featureId + ", name=" + name + '}';
    }
    
    
    
}
