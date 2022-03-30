package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Salesperson extends AbstractEntity {
	@NotEmpty
	private String firstName = " ";
	
	@NotEmpty
	private String lastName = " ";
	
	@NotEmpty
	private String address = " ";
	
	private long phone;
	private int startDate;
	private int terminationDate;
	
	@NotEmpty
	private String manager = " ";
	
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
	
	public long getPhone() {
		return phone;
	}
	
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public int getStartDate() {
		return startDate;
	}
	
	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}
	
	public int getTerminationDate() {
		return terminationDate;
	}
	
	public void setTerminationDate(int terminationDate) {
		this.terminationDate = terminationDate;
	}
	
	public String getManager() {
		return manager;
	}
	
	public void setManager(String manager) {
		this.manager = manager;
	}
}
