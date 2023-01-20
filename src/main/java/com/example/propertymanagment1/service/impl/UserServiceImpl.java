package com.example.propertymanagment1.service.impl;

import com.example.propertymanagment1.converter.UserConverter;
import com.example.propertymanagment1.entity.UserEntity;
import com.example.propertymanagment1.exception.BusinessException;
import com.example.propertymanagment1.exception.ErrorModel;
import com.example.propertymanagment1.modelOrDto.UserDTO;
import com.example.propertymanagment1.repository.UserRepository;
import com.example.propertymanagment1.service.facde.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {

        Optional<UserEntity> loadedUser = userRepository.findByUserEmail(userDTO.getUserEmail());
        if (loadedUser.isPresent()) {

            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXIST");
            errorModel.setMessage("The Email With You Are Trying To Register Already Exists");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);

        } else {
            UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
            userEntity = userRepository.save(userEntity);
            userDTO = userConverter.convertEntityToDto(userEntity);
        }
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserEmailAndPassword(email, password);

        if (optionalUserEntity.isPresent()) {
            userDTO = userConverter.convertEntityToDto(optionalUserEntity.get());
        } else {

            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return userDTO;
    }
}
