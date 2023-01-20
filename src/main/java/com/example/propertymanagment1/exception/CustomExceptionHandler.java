package com.example.propertymanagment1.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice // tell springboot => this class handler all exception
public class CustomExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass()); // this.getClass() = CustomExceptionHandler.class

    @ExceptionHandler(BusinessException.class) // BusinessException.class = type of exception
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex) {

        for (ErrorModel bexError : bex.getErrors()) {
            logger.debug("BusinessException is thrown -level-debug: {} - {}", bexError.getCode(), bexError.getMessage());
            logger.info("BusinessException is thrown -level-info: {} - {}", bexError.getCode(), bexError.getMessage());
            logger.warn("BusinessException is thrown -level-warn: {} - {}", bexError.getCode(), bexError.getMessage());
            logger.error("BusinessException is thrown -level-error: {} - {}", bexError.getCode(), bexError.getMessage());
        }
        return new ResponseEntity<List<ErrorModel>>(bex.getErrors(), HttpStatus.BAD_REQUEST);
    }

    // Annotation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manv) {

        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = null;
        List<FieldError> fieldErrorList = manv.getBindingResult().getFieldErrors();

        for (FieldError fieldError : fieldErrorList) {
            logger.debug("Inside field validation: {} - {}", fieldError.getField(), fieldError.getDefaultMessage());
            logger.info("Inside field validation: {} - {}", fieldError.getField(), fieldError.getDefaultMessage());
            errorModel = new ErrorModel();
            errorModel.setCode(fieldError.getField());
            errorModel.setMessage(fieldError.getDefaultMessage());
            errorModelList.add(errorModel);
        }

        return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);


    }
}
