/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.ContactInformationDto;
import java.util.List;

/**
 *
 * @author Cna
 */
public interface ContactInformationDao {
    
    public List<ContactInformationDto> getAllContactInformations();
    public ContactInformationDto getContactInfoById(int id);
    public ContactInformationDto addContactInfo(ContactInformationDto contact);
    public void updateContact(ContactInformationDto contact);
    public void deleteContactById(int id);
    
}
