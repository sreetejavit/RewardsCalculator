package com.example.service.springbootrewards.rewards;

import com.example.service.springbootrewards.exceptions.CustomerNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.service.springbootrewards.model.Customer;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/rewards")
public class RewardsController {

	@Autowired
	private RewardsService rewardsService;

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> findAllCustomers() {
		try {
			List<Customer> customers = rewardsService.getCustomerAll();
			return ResponseEntity.ok(customers); // 200 OK
		} catch (Exception ex) {
			if (ex instanceof NullPointerException) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
		try {
			Optional<Customer> customer = rewardsService.getCustomerById(id);
      return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
		} catch (Exception ex) {
			if (ex instanceof NullPointerException) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}





