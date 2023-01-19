package com.example.propertymanagment1.repository;

import com.example.propertymanagment1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByUserEmailAndPassword();

}
