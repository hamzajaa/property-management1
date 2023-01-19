package com.example.propertymanagment1.converter;

import com.example.propertymanagment1.entity.PropertyEntity;
import com.example.propertymanagment1.modelOrDto.PropertyDTO;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setAddress(propertyDTO.getAddress());
        pe.setDescription(propertyDTO.getDescription());
        pe.setPrice(propertyDTO.getPrice());
        return pe;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity) {
        PropertyDTO pd = new PropertyDTO();
        pd.setId(propertyEntity.getId());
        pd.setTitle(propertyEntity.getTitle());
        pd.setAddress(propertyEntity.getAddress());
        pd.setDescription(propertyEntity.getDescription());
        pd.setPrice(propertyEntity.getPrice());
        return pd;
    }
}
