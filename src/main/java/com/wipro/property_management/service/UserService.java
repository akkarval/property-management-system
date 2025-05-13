package com.wipro.property_management.service;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.wipro.property_management.dto.UserDTO;


public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);
}
