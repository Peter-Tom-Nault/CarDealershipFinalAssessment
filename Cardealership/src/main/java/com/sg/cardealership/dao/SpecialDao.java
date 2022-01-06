/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.Special;
import java.util.List;

/**
 *
 * @author Cna
 */
public interface SpecialDao {
    
    public List<Special> getAllSpecials();
    public Special getSpecialById(int id);
    public Special addSpecialInfo(Special special);
    public void updateSpecial(Special special);
    public void deleteSpecialById(int id);
    
}
