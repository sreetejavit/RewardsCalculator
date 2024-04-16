package com.example.service.springbootrewards.rewards;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.service.springbootrewards.model.Customer;
import com.example.service.springbootrewards.model.CustomerTransaction;

@Service
public class RewardsServiceMock {

	private static final List<CustomerTransaction> transactions = new ArrayList<CustomerTransaction>();
	private static int index;
	
	static {
		
		transactions.add( new CustomerTransaction(index++, new Customer(1, "Sreeteja M"), 170.0, "Purchase 1", new Date()) );
		transactions.add( new CustomerTransaction(index++, new Customer(2, "Bharath M"), 55.0, "Purchase 2", new Date()) );
		transactions.add( new CustomerTransaction(index++, new Customer(3, "Harshith Ram"), 200.0, "Purchase 3", new Date()) );
	
	}
	
	
	public List<CustomerTransaction> getAll() {
		return transactions;
	}
	
}



