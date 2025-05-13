package com.wipro.property_management.service.implementation;

import com.wipro.property_management.converter.UserConverter;
import com.wipro.property_management.dto.UserDTO;
import com.wipro.property_management.entity.UserEntity;
import com.wipro.property_management.exception.BusinessException;
import com.wipro.property_management.exception.ErrorModel;
import com.wipro.property_management.repository.UserRepository;
import com.wipro.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,UserConverter userConverter ){
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserDTO register(UserDTO userDTO) throws BusinessException {
        Optional<UserEntity> optionalUser = userRepository.findByUserEmail(userDTO.getUserEmail());
        if (optionalUser.isPresent()) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXISTS");
            errorModel.setMessage("The Email with which you are trying to register already exists!");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);

        } else {
            UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
            userEntity = userRepository.save(userEntity);
            userDTO = userConverter.convertEntitytoDTO(userEntity);
            return userDTO;
        }
    }
    @Override
    public UserDTO login(String email, String password) throws BusinessException {
        UserDTO userDTO = null;
    Optional<UserEntity>userEntity =userRepository.findByUserEmailAndPassword(email,password);
    if(userEntity.isPresent()){
        userDTO = userConverter.convertEntitytoDTO(userEntity.get());
    }else{
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode("INVALID_LOGIN");
        errorModel.setMessage("Incorrect Email or Password!");
        errorModelList.add(errorModel);
        throw new BusinessException(errorModelList);
    }
        return userDTO;
    }
}
