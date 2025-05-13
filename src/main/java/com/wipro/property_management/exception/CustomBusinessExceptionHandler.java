package com.wipro.property_management.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomBusinessExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(CustomBusinessExceptionHandler.class);//this.getClass()

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manvex){

        ErrorModel  errorModel = null;
        List<ErrorModel> errorModelList = new ArrayList<>();
        List<FieldError> fieldErrorList = manvex.getBindingResult().getFieldErrors();

        for(FieldError fe: fieldErrorList){
           logger.info("Inside Field validation : {} - {}", fe.getField(), fe.getDefaultMessage());
           logger.debug("Inside Field validation : {} - {}", fe.getField(), fe.getDefaultMessage());
         errorModel = new ErrorModel();
         errorModel.setCode(fe.getField());
         errorModel.setMessage(fe.getDefaultMessage());
         errorModelList.add(errorModel);
        }
        return new ResponseEntity<>(errorModelList,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>>  handleBusinessException(BusinessException businessException){
        for(ErrorModel em: businessException.getErrors()) {
            logger.info("BusinessException is thrown. Exception is: {} - {}  ", em.getCode(), em.getMessage());
            logger.debug("BusinessException is thrown. Exception is: {} - {} ", em.getCode(), em.getMessage());
        }
        return new ResponseEntity<>(businessException.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
