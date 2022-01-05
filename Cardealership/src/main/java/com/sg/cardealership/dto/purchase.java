/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * here purchase manage user and vehicle
 * @author Cna
 */
public class purchase {
    private UserDto user;
    private VehicleDto vehicle;
    private LocalDate date;
    private BigDecimal price;
    private String custName;
    private String email;
    
    private Address address;
    
}
