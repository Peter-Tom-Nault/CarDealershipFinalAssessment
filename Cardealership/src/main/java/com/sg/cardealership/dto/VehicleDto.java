/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dto;

import java.util.List;

/**
 * here vehicle manages manufacture, model and optional
 * @author Cna
 */
public class VehicleDto {
    private String vin;
    private int year;
    private String exteriorColor;
    private String interiorColor;
    private String bodyType;
    private String transmission;
    private String msrp;
    private String salePrice;
    private String photo;
    private int mileage;
    private String description;
    private boolean purchased;
    private boolean featured;
    
    private ModelDto model;
    private List<OptionalFeatureDto> optional;
    
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getExteriorColor() {
		return exteriorColor;
	}
	public void setExteriorColor(String exteriorColor) {
		this.exteriorColor = exteriorColor;
	}
	public String getInteriorColor() {
		return interiorColor;
	}
	public void setInteriorColor(String interiorColor) {
		this.interiorColor = interiorColor;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getMsrp() {
		return msrp;
	}
	public void setMsrp(String msrp) {
		this.msrp = msrp;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPurchased() {
		return purchased;
	}
	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}
	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	public ModelDto getModel() {
		return model;
	}
	public void setModel(ModelDto model) {
		this.model = model;
	}
	public List<OptionalFeatureDto> getOptional() {
		return optional;
	}
	public void setOptional(List<OptionalFeatureDto> optional) {
		this.optional = optional;
	}
    
    
    
}
