package com.example.SpringBootAcademy.adviser;

import com.example.SpringBootAcademy.exception.NotFoundException;
import com.example.SpringBootAcademy.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundExcepion(NotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Error Comming",e.getMessage()),
                HttpStatus.NOT_FOUND
        );

    }
}
