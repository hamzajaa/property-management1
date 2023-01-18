package com.example.propertymanagment1.repository;

import com.example.propertymanagment1.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {


}
