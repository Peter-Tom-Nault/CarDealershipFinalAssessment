/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dto;

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
    
    
}
