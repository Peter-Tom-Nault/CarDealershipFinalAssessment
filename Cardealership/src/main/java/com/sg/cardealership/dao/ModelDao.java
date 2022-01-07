/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.ManufacturerDto;
import com.sg.cardealership.dto.ModelDto;
import java.util.List;

/**
 *
 * @author Cna
 */
public interface ModelDao {
    public ModelDto getModelByid(int id);
    public List<ModelDto> getAllModels();
    public List<ModelDto> getModelsForManufacturer(ManufacturerDto man);
    public ModelDto addModel(ModelDto model);
    public void updateModel(ModelDto model);
    public void deleteModel(int id);
}
