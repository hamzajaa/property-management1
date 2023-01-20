package com.example.propertymanagment1.service.facde;

import com.example.propertymanagment1.entity.UserEntity;
import com.example.propertymanagment1.modelOrDto.UserDTO;

import java.util.Optional;

public interface UserService {

     UserDTO register(UserDTO userDTO);
     UserDTO login(String email, String password);


}
