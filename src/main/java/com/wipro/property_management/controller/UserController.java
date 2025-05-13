package com.wipro.property_management.controller;

import com.wipro.property_management.dto.UserDTO;
import com.wipro.property_management.exception.BusinessException;
import com.wipro.property_management.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO) throws BusinessException {
        userDTO =   userService.register(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserDTO userDTO) throws BusinessException {
        userDTO = userService.login(userDTO.getUserEmail(), userDTO.getPassword());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
