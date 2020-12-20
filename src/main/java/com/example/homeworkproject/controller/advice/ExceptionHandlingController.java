package com.example.homeworkproject.controller.advice;

import com.example.homeworkproject.controller.response.Response;
import com.example.homeworkproject.service.exception.ClientNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler({ClientNotFoundException.class})
    public ResponseEntity<ErrorResponse> handle(Exception exception){
        ErrorResponse error = new ErrorResponse("Client not found");
        return ResponseEntity.badRequest().body(error);
    }

}
