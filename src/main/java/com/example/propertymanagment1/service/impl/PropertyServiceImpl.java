package com.example.propertymanagment1.service.impl;

import com.example.propertymanagment1.converter.PropertyConverter;
import com.example.propertymanagment1.entity.PropertyEntity;
import com.example.propertymanagment1.modelOrDto.PropertyDTO;
import com.example.propertymanagment1.repository.PropertyRepository;
import com.example.propertymanagment1.service.facde.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service  // @Component @Configuration @Repository => same functionality
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity propertyEntity = propertyConverter.convertDTOtoEntity(propertyDTO);
        propertyEntity = propertyRepository.save(propertyEntity);

        PropertyDTO dto = propertyConverter.convertEntityToDTO(propertyEntity);
        return dto;
    }

    @Override
    public List<PropertyDTO> findAll() {

        List<PropertyEntity> listProperties = (List<PropertyEntity>) propertyRepository.findAll();

        List<PropertyDTO> propertyDTOStream = listProperties.stream().map(pe -> propertyConverter.convertEntityToDTO(pe)).toList();

//        List<PropertyDTO> propertyDTOList = new ArrayList<>();
//        for (PropertyEntity pe : listProperties) {
//            PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
//            propertyDTOList.add(dto);
//        }

        return propertyDTOStream;
    }

    @Override
    public PropertyDTO update(PropertyDTO propertyDTO) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyDTO.getId());
        PropertyDTO dto = null;
        if (optEn.isPresent()) {
            PropertyEntity pe = optEn.get(); // data from database
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setDescription(propertyDTO.getDescription());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setPrice(propertyDTO.getPrice());

            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updateDescription(PropertyDTO propertyDTO) {

        Optional<PropertyEntity> foundedProperty = propertyRepository.findById(propertyDTO.getId());
        PropertyDTO dto = null;
        if (foundedProperty.isPresent()) {
            PropertyEntity propertyEntity = foundedProperty.get();

            propertyEntity.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntityToDTO(propertyEntity);

            propertyRepository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePrice(PropertyDTO propertyDTO) {

        Optional<PropertyEntity> foundedProperty = propertyRepository.findById(propertyDTO.getId());
        PropertyDTO dto = null;
        if (foundedProperty.isPresent()) {
            PropertyEntity propertyEntity = foundedProperty.get();

            propertyEntity.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntityToDTO(propertyEntity);

            propertyRepository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        Optional<PropertyEntity> foundedProperty = propertyRepository.findById(id);
        if (foundedProperty.isPresent()) {
            PropertyEntity propertyEntity = foundedProperty.get();
            propertyRepository.deleteById(propertyEntity.getId());
            res = 1;
        }
        return res;
    }
}
