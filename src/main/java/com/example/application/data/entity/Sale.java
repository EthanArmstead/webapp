package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Sale extends AbstractEntity{
	//@NotEmpty
	private int salesDate = 0;
	
	@Nullable
	@ManyToOne
	private Salesperson salesperson;
	
	@Nullable
	@ManyToOne
    private Product product;
	
	@Nullable
	@ManyToOne
    private Customer customer;
	
	public int getSalesDate() {
		return salesDate;
	}
	
	public void setSalesDate(int salesDate) {
		this.salesDate = salesDate;
	}
	
	public Salesperson getSalesperson() {
		return salesperson;
	}
	
	public void setSalesperson(Salesperson salesperson) {
		this.salesperson = salesperson;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
