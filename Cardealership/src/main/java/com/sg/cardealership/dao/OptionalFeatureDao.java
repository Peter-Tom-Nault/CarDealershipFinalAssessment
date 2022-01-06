/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.OptionalFeatureDto;
import java.util.List;

/**
 *
 * @author Cna
 */
public interface OptionalFeatureDao {
    public List<OptionalFeatureDto> getAllOptionalFeatures();
    public OptionalFeatureDto getOptionalFeatureById(int id);
    public OptionalFeatureDto addOptionalFeature(OptionalFeatureDto option);
    public void updateOptionalFeature(OptionalFeatureDto option);
}
