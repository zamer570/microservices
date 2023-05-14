package com.example.HotelService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> exception(ResourceNotFoundException ex){
        Map<Object, Object> mp  =new HashMap<>();
        mp.put("message",ex.getMessage());
        mp.put("success",true);
        mp.put("status",HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(mp,HttpStatus.NOT_FOUND);
    }
}
