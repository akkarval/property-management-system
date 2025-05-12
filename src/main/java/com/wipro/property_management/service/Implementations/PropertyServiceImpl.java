package com.wipro.property_management.service.Implementations;


import com.wipro.property_management.converter.PropertyConverter;
import com.wipro.property_management.dto.PropertyDTO;
import com.wipro.property_management.entity.PropertyEntity;
import com.wipro.property_management.repository.PropertyRepository;
import com.wipro.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        System.out.println(propertyDTO);
PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
        System.out.println(pe);
        pe = propertyRepository.save(pe);
        propertyDTO = propertyConverter.convertEntityToDTO(pe);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {

       List<PropertyEntity> propertyEntityList = (List<PropertyEntity>) propertyRepository.findAll();
       List<PropertyDTO> propList = new ArrayList<>();
       for(PropertyEntity pe : propertyEntityList) {
    PropertyDTO dto =  propertyConverter.convertEntityToDTO(pe);
    propList.add(dto);
       }
        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if (propertyEntity.isPresent()) {
            PropertyEntity pe = propertyEntity.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setDescription(propertyDTO.getDescription());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setPrice(propertyDTO.getPrice());
            pe.setAddress(propertyDTO.getAddress());
            propertyRepository.save(pe);
            dto = propertyConverter.convertEntityToDTO(pe);

        }

        return dto;

    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
       Optional<PropertyEntity> propertyEntity =  propertyRepository.findById(propertyId);
       PropertyDTO dto = null;

       if(propertyEntity.isPresent()){
           PropertyEntity pe = propertyEntity.get();
           pe.setDescription(propertyDTO.getDescription());
           propertyRepository.save(pe);
           dto = propertyConverter.convertEntityToDTO(pe);
       }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(propertyEntity.isPresent()){
            PropertyEntity pe = propertyEntity.get();
            pe.setPrice(propertyDTO.getPrice());
            propertyRepository.save(pe);
            dto = propertyConverter.convertEntityToDTO(pe);
        }

        return dto;
    }

    @Override
    public PropertyDTO deleteProperty(Long propertyId) {
       Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyId);
       propertyRepository.deleteById(propertyId);
       PropertyDTO dto = null;

       if(propertyEntity.isPresent()){
        PropertyEntity pe = propertyEntity.get();
        dto = propertyConverter.convertEntityToDTO(pe);
       }
        return dto;
    }

}
