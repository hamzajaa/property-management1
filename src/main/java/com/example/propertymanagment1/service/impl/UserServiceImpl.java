package com.example.propertymanagment1.service.impl;

import com.example.propertymanagment1.converter.UserConverter;
import com.example.propertymanagment1.entity.UserEntity;
import com.example.propertymanagment1.modelOrDto.UserDTO;
import com.example.propertymanagment1.repository.UserRepository;
import com.example.propertymanagment1.service.facde.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        userDTO = userConverter.convertEntityToDto(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
