package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Customer extends AbstractEntity {
	@NotEmpty
	private String firstName = " ";
	
	@NotEmpty
	private String lastName = " ";
	
	@NotEmpty
	private String address = " ";
	
	@NotEmpty
	private String phone = " ";
	
	//@NotEmpty
	private int startDate = 0;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getStartDate() {
		return startDate;
	}
	
	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}
}
