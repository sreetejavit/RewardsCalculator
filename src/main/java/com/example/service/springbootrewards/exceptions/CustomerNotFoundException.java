package com.example.service.springbootrewards.exceptions;

public class CustomerNotFoundException extends Exception{
  public CustomerNotFoundException(String message) {
    super(message);
  }
}
