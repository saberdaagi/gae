package com.teckup.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;

@ControllerAdvice
@Slf4j
public class ExcpetionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> defaultErrorHandler(@NonNull Exception exception) {
        log.error("Unhandled exception occured", exception);
        return ResponseEntity.badRequest().body(exception.getMessage());
    }


    @ExceptionHandler(ParseException.class)
    public ResponseEntity<String> parseErrorHandler(@NonNull ParseException exception) {
        log.error("Unhandled exception occured", exception);
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
