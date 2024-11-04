package org.example.springboot.controller;

import org.example.springboot.Dtos.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse>  handleHttpMessageNotReadable(HttpMessageNotReadableException e){

        return ResponseEntity.badRequest()
                .body(new ApiResponse("Invalid Input for Level field" , null) );

    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        for( FieldError fieldError : ex.getBindingResult().getFieldErrors()){
//            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
//        }
//        return ResponseEntity.badRequest()
//                .body(errors);
//    }




}
