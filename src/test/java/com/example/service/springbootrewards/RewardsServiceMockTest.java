package com.example.service.springbootrewards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.service.springbootrewards.model.Customer;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.service.springbootrewards.rewards.RewardsServiceMock;
import com.example.service.springbootrewards.model.CustomerTransaction;
import org.mockito.Mock;

public class RewardsServiceMockTest {

	@Test
	public void testGetAllTransactions() {
		RewardsServiceMock service = new RewardsServiceMock();
		List<CustomerTransaction> transactions = service.getAll();
		// Assert that the list is not null
		assertNotNull(transactions, "Transactions list should not be null");

		// Assert the expected size of the list
		assertEquals(3, transactions.size(), "Transactions list should contain 3 elements");
	}

//	@InjectMocks
//	private CustomerTransaction transaction;

	@Mock
	private Customer customer; // Mock Customer object

	@Test
	public void testGetPoints_Below50() {
		CustomerTransaction transaction = new CustomerTransaction(1, null, 20.0, "Purchase 1", new java.util.Date());

		// Call getPoints and assert
		int points = transaction.getPoints();
		assertEquals(0, points, "Points should be 0 for transaction below $50");
	}

	@Test
	public void testGetPoints_Between50and100() {
		CustomerTransaction transaction = new CustomerTransaction(1, null, 75.0, "Purchase 2", new java.util.Date());
		// Set transaction total between 50 and 100
//		when(transaction.getTotal()).thenReturn(75.0);

		// Call getPoints and assert
		int points = transaction.getPoints();
		assertEquals(25, points, "Points should be 25 for transaction between $50 and $100");
	}

	@Test
	public void testGetPoints_Above100() {
		// Set transaction total above 100
		CustomerTransaction transaction = new CustomerTransaction(1, null, 150.0, "Purchase 2", new java.util.Date());
		// Call getPoints and assert
		int points = transaction.getPoints();
		assertEquals(150, points, "Points should be 100 for transaction above $100");
	}

	@Test
	public void testGetPoints_WithDecimalPoints() {
		CustomerTransaction transaction = new CustomerTransaction(1, null, 224.69, "Purchase 2", new java.util.Date());

		// Call getPoints and assert (modify assertion based on your complex calculation)
		int points = transaction.getPoints();
		assertEquals(298, points, "Points should be calculated correctly for complex scenario"); // Adjust assertion value
	}

	@Test
	public void testGetPoints_CornerCaseWith51() {
		// Set transaction to test 51
		CustomerTransaction transaction = new CustomerTransaction(1, null, 51.0, "Purchase 2", new java.util.Date());
		// Call getPoints and assert
		int points = transaction.getPoints();
		assertEquals(1, points, "Points should be 100 for transaction above $100");
	}

	@Test
	public void testGetPoints_CornerCaseWith99() {
		// Set transaction to test 99
		CustomerTransaction transaction = new CustomerTransaction(1, null, 99.0, "Purchase 2", new java.util.Date());
		// Call getPoints and assert
		int points = transaction.getPoints();
		assertEquals(49, points, "Points should be 100 for transaction above $100");
	}

	@Test
	public void testGetPoints_CornerCaseWith101() {
		// Set transaction to test 101
		CustomerTransaction transaction = new CustomerTransaction(1, null, 101.0, "Purchase 2", new java.util.Date());
		// Call getPoints and assert
		int points = transaction.getPoints();
		assertEquals(52, points, "Points should be 100 for transaction above $100");
	}
}
