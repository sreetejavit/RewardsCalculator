package com.example.service.springbootrewards.exceptions;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NumberFormatException.class)
  public ResponseEntity<?> handleNumberFormatException(NumberFormatException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body("Invalid input format. Please provide a valid integer value.");
  }
//
//  @ExceptionHandler(IllegalArgumentException.class)
//  public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {
//    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//        .body("Invalid customer ID provided.");
//  }
//
//  @ExceptionHandler(NoSuchElementException.class)
//  public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException ex) {
//    return ResponseEntity.status(HttpStatus.NOT_FOUND)
//        .body("Customer not found.");
//  }
//
//  @ExceptionHandler(Exception.class)
//  public ResponseEntity<?> handleOtherExceptions(Exception ex) {
//    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//        .body("An internal server error occurred.");
//  }
}
