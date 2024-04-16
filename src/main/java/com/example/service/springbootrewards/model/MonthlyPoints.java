package com.example.service.springbootrewards.model;

import javax.persistence.*;

@Entity
public class MonthlyPoints {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment
  private int id;

  @ManyToOne
  @JoinColumn(name = "customer_id") // Foreign key to Customer table
  private Customer customer;

  private int month; // Month (1-12)

  private Long points; // Total points earned in that month

  public MonthlyPoints() {
  }

  public MonthlyPoints(Customer customer, int month, Long points) {
    this.customer = customer;
    this.month = month;
    this.points = points;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public Long getPoints() {
    return points;
  }

  public void setPoints(Long points) {
    this.points = points;
  }

  @Override
  public String toString() {
    return "MonthlyPoints [id=" + id + ", customer=" + customer + ", month=" + month + ", points=" + points + "]";
  }
}
