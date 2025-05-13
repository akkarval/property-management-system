package com.wipro.property_management.service.Implementations;

import com.wipro.property_management.converter.UserConverter;
import com.wipro.property_management.dto.UserDTO;
import com.wipro.property_management.entity.UserEntity;
import com.wipro.property_management.repository.UserRepository;
import com.wipro.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }
    @Override
    public UserDTO login(String email, String password) {

        return null;
    }
}
