package com.wipro.property_management.converter;

import com.wipro.property_management.dto.UserDTO;
import com.wipro.property_management.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

   public UserEntity convertDTOtoEntity(UserDTO userDTO){
       UserEntity userEntity = new UserEntity();
       userEntity.setUserName(userDTO.getUserName());
       userEntity.setUserEmail(userDTO.getUserEmail());
       userEntity.setPhone(userDTO.getPhone());
       userEntity.setPassword(userDTO.getPassword());
       return userEntity;
   }

   public UserDTO convertEntitytoDTO(UserEntity userEntity){
       UserDTO dto = new UserDTO();
       dto.setId(userEntity.getId());
       dto.setUserName(userEntity.getUserName());
       dto.setUserEmail(userEntity.getUserEmail());
       dto.setPhone(userEntity.getPhone());
       //dto.setPassword(userEntity.getPassword());
       return dto;
   }



}
