package com.example.service.springbootrewards.rewards;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.springbootrewards.model.Customer;

@Service
public class RewardsService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public List<Customer> getCustomerAll() {
		return customerRepository.findAll();
	}

	public Optional<Customer> getCustomerById(Integer customerId) {
		return customerRepository.findById(customerId);
	}
}
