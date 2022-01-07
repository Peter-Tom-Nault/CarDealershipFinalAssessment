/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * here purchase manage user and vehicle
 * @author Cna
 */
public class purchase {
    private UserDto user;
    private VehicleDto vehicle;

    private int id;
    private LocalDate date;
    private BigDecimal price;
    private String custName;
    private String email;
    
    private Address address;

    public UserDto getUser() {
            return user;
    }

    public void setUser(UserDto user) {
            this.user = user;
    }

    public VehicleDto getVehicle() {
            return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
            this.vehicle = vehicle;
    }

    public LocalDate getDate() {
            return date;
    }

    public void setDate(LocalDate date) {
            this.date = date;
    }

    public BigDecimal getPrice() {
            return price;
    }

    public void setPrice(BigDecimal price) {
            this.price = price;
    }

    public String getCustName() {
            return custName;
    }

    public void setCustName(String custName) {
            this.custName = custName;
    }

    public String getEmail() {
            return email;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public Address getAddress() {
            return address;
    }

    public void setAddress(Address address) {
            this.address = address;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.user);
        hash = 89 * hash + Objects.hashCode(this.vehicle);
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.date);
        hash = 89 * hash + Objects.hashCode(this.price);
        hash = 89 * hash + Objects.hashCode(this.custName);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.address);
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
        final purchase other = (purchase) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.custName, other.custName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.vehicle, other.vehicle)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "purchase{" + "user=" + user + ", vehicle=" + vehicle + ", id=" + id + ", date=" + date + ", price=" + price + ", custName=" + custName + ", email=" + email + ", address=" + address + '}';
    }
    
    
}
