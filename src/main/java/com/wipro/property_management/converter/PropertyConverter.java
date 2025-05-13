package com.wipro.property_management.converter;

import com.wipro.property_management.dto.PropertyDTO;
import com.wipro.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){

        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setPrice(propertyDTO.getPrice());
        pe.setAddress(propertyDTO.getAddress());
        return pe;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity){

        System.out.println(propertyEntity);
        PropertyDTO pd = new PropertyDTO();
        pd.setId(propertyEntity.getId());
        pd.setTitle(propertyEntity.getTitle());
        pd.setDescription(propertyEntity.getDescription());
        pd.setPrice(propertyEntity.getPrice());
        pd.setAddress(propertyEntity.getAddress());

        return pd;
    }
}
