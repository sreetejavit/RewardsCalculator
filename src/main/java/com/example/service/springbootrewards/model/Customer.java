package com.example.service.springbootrewards.model;

import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@JsonPropertyOrder({"id", "name", "rewardPoints", "totalPurchases"})
public class Customer {

	@Id
	@GeneratedValue
	private int id; // Using int ideally should use long

	private String name;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<CustomerTransaction> transactions;

//	@JsonInclude
//	@JsonProperty(access = Access.READ_ONLY)
//	private Set<MonthlyPoints> monthlyPoints = new HashSet<>();

	@JsonInclude
	@JsonProperty(access = JsonProperty.Access.READ_ONLY) // Mark as read-only for serialization
	private Long rewardPoints;

	@JsonInclude
	@JsonProperty(access = JsonProperty.Access.READ_ONLY) // Mark as read-only for serialization
	private Double totalPurchases;

	public Customer() {
	}

	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CustomerTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<CustomerTransaction> transactions) {
		this.transactions = transactions;
	}

//	public Set<MonthlyPoints> getMonthlyPoints() {
//		return monthlyPoints;
//	}
//
//	public void setMonthlyPoints(
//			Set<MonthlyPoints> monthlyPoints) {
//		this.monthlyPoints = monthlyPoints;
//	}

	public Long getRewardPoints() {
		if (transactions == null || transactions.isEmpty()) {
			return 0L;
		}
		return transactions.stream().mapToLong(CustomerTransaction::getPoints).sum();
	}

	public Double getTotalPurchases() {
		if (transactions == null || transactions.isEmpty()) {
			return 0d;
		}
		return transactions.stream().mapToDouble(CustomerTransaction::getTotal).sum();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return getId() == customer.getId();
	}

	@Override
	public int hashCode() {
		return getId();
	}
}
