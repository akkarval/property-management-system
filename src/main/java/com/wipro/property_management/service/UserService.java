package com.wipro.property_management.service;
import com.wipro.property_management.dto.UserDTO;
import com.wipro.property_management.exception.BusinessException;


public interface UserService {
    UserDTO register(UserDTO userDTO) throws BusinessException;
    UserDTO login(String email, String password) throws BusinessException;
}
