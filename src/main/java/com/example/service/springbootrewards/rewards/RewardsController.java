package com.example.service.springbootrewards.rewards;

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
	public ResponseEntity<?> findAllCustomers() {
		List<Customer> customers = rewardsService.getCustomerAll();
		return ResponseEntity.ok(customers); // 200 OK
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable Integer id) {
		Optional<Customer> customer = rewardsService.getCustomerById(id);
		if (customer.isPresent())
			return ResponseEntity.ok(customer.get());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
	}
}





