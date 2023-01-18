package com.example.propertymanagment1.service.facde;

import com.example.propertymanagment1.modelOrDto.PropertyDTO;

import java.util.List;

public interface PropertyService {

    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> findAll();

    PropertyDTO update(PropertyDTO propertyDTO);
    PropertyDTO updateDescription(PropertyDTO propertyDTO);
    PropertyDTO updatePrice(PropertyDTO propertyDTO);

    int deleteById(Long id);
}
