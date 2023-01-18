package com.example.propertymanagment1.controller;

import com.example.propertymanagment1.modelOrDto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator") // class level mapping of url to a controller class
public class CalculatorController {

    // http://localhost:8080/api/v1/calculator/add
    // http://localhost:8080/api/v1/calculator/add?num111=6.8&num222=1.3
    @GetMapping("/add") // method level mapping of url to a controller class
    public Double add(@RequestParam("num111") Double num1, @RequestParam("num222") Double num2) {
        return num1 + num2;
    }

    // http://localhost:8080/api/v1/calculator/add/52.4?num111=6.8&num222=1.3
    @GetMapping("/add2/{num3}") // method level mapping of url to a controller class
    public Double add2(@RequestParam("num111") Double num1, @RequestParam("num222") Double num2,
                       @PathVariable("num3") Double num3) {
        return num1 + num2;
    }

    // http://localhost:8080/api/v1/calculator/sub/4.89/8.66
    @GetMapping("/sub/{num1}/{num2}") // Map values of url to java variables by Path Variable method
    public Double substract(@PathVariable Double num1, @PathVariable Double num2) {
        Double result = null;
        if (num1 > num2) {
            result = num1 - num2;
        } else {
            result = num2 - num1;
        }
        return result;
    }

    @GetMapping("/sub/{num11}/{num2}") // Map values of url to java variables by Path Variable method
    public Double substract2(@PathVariable("num11") Double num1, @PathVariable("num2") Double num2) {
        Double result = null;
        if (num1 > num2) {
            result = num1 - num2;
        } else {
            result = num2 - num1;
        }
        return result;
    }

    @PostMapping("/mult")
    public Double multiply(@RequestBody CalculatorDTO calculatorDTO) {
        Double result = null;
        result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4();
        return result;
    }

    @PostMapping("/mult2")
    public ResponseEntity multiply2(@RequestBody CalculatorDTO calculatorDTO) {
        Double result = null;
        result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
