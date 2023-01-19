package com.example.propertymanagment1.converter;

import com.example.propertymanagment1.entity.UserEntity;
import com.example.propertymanagment1.modelOrDto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertDTOtoEntity(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserEmail(userDTO.getUserEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setPhone(userDTO.getPhone());

        return userEntity;
    }


    public UserDTO convertEntityToDto(UserEntity userEntity) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setUserEmail(userEntity.getUserEmail());
        userDTO.setPhone(userEntity.getPhone());

        return userDTO;
    }
}
