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
public class ContactInformationDto {
    private int id;
    private String firstName;
    private String lastName;
    private String message;
    private String email;
    private int phone;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
            return firstName;
    }
    public void setFirstName(String firstName) {
            this.firstName = firstName;
    }
    public String getLastName() {
            return lastName;
    }
    public void setLastName(String lastName) {
            this.lastName = lastName;
    }
    public String getMessage() {
            return message;
    }
    public void setMessage(String message) {
            this.message = message;
    }
    public String getEmail() {
            return email;
    }
    public void setEmail(String email) {
            this.email = email;
    }
    public int getPhone() {
            return phone;
    }
    public void setPhone(int phone) {
            this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.lastName);
        hash = 53 * hash + Objects.hashCode(this.message);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + this.phone;
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
        final ContactInformationDto other = (ContactInformationDto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.phone != other.phone) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContactInformationDto{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", message=" + message + ", email=" + email + ", phone=" + phone + '}';
    }
    
    
}
