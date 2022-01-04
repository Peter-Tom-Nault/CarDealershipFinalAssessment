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
    
    private ManufacturerDto manufacture;
    private ModelDto model;
    private List<OptionalFeatureDto> optional;
    
}
