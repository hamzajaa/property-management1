package com.example.propertymanagment1.repository;

import com.example.propertymanagment1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserEmailAndPassword(String email, String password);

    Optional<UserEntity> findByUserEmail(String email);

}
