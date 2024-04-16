package com.example.service.springbootrewards.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CustomerTransaction implements Reward {
	@Id
	@GeneratedValue
	private Integer id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn //foreign key to customer
	private Customer customer;

	private Double total;
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date saveDate;

  public CustomerTransaction() {
	}

	public CustomerTransaction(Integer id, Customer customer, Double total, String description, Date saveDate) {
		this.id = id;
		this.customer = customer;
		this.total = total;
		this.description = description;
		this.saveDate = saveDate;
	}

	public Date getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int getPoints() {
    int points = 0;

		if (this.total == null) {
			return points;
		}

		if (this.total > 50 && this.total <= 100) {
			points += (this.total.intValue() - 50);
		}

		if (this.total > 100) {
			points += 50;  //1 point for every dollar spent over $50
			points += (this.total.intValue() - 100) * 2;  //2 points for every dollar spent over $100
		}

		return points;
	}

	@Override
	public String toString() {
		return String.format("CustomerTransaction [id=%s, customer=%s, total=%s, description=%s, saveDate=%s]", id, customer,
				total, description, saveDate);
	}

}