package com.example.propertymanagment1.controller;

import com.example.propertymanagment1.modelOrDto.PropertyDTO;
import com.example.propertymanagment1.service.facde.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    // do that in any class
    @Value("${pms.dummy:}") // : means id don't exist any value , the value is null as default
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dbUrl;

    @Autowired // create an instance object of Bean PropertyServiceImpl and injected to this class
    private PropertyService propertyService;

    // RESTFUL API is just mapping of a url to a Java Class function
    // http://localhost:8080/api/v1/properties/hello => RestFul
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @PostMapping("/save")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {

        propertyDTO = propertyService.saveProperty(propertyDTO);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {

        System.out.println(dummy);
        System.out.println(dbUrl);

        List<PropertyDTO> propertyList = propertyService.findAll();

        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/")
    public ResponseEntity<PropertyDTO> update(@RequestBody PropertyDTO propertyDTO) {

        propertyDTO = propertyService.update(propertyDTO);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("/descripton")
    public ResponseEntity<PropertyDTO> updateDescription(@RequestBody PropertyDTO propertyDTO) {

        propertyDTO = propertyService.updateDescription(propertyDTO);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("/price")
    public ResponseEntity<PropertyDTO> updatePrice(@RequestBody PropertyDTO propertyDTO) {

        propertyDTO = propertyService.updatePrice(propertyDTO);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return propertyService.deleteById(id);
    }
}
