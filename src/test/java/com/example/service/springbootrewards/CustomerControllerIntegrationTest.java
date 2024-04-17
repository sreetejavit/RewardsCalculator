package com.example.service.springbootrewards;

import com.example.service.springbootrewards.model.Customer;
import com.example.service.springbootrewards.rewards.CustomerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class CustomerControllerIntegrationTest {

  @Autowired
  private CustomerController customerController;

  @Test
  public void testAddCustomer() {
    Customer newCustomer = new Customer(1001, "John Doe");

    // Send a POST request to the customer creation endpoint
    ResponseEntity<Customer> response = customerController.createCustomer(newCustomer);

    // Assert successful response status code (e.g., CREATED)
    Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

    // Assert the saved customer object has the expected details
    Customer savedCustomer = response.getBody();
    Assertions.assertEquals("John Doe", savedCustomer.getName());
  }
}
